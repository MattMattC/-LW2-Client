package com.lw2.web.controller;

import com.lw2.web.model.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    /**
     * Affiche le home
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        return "home";

    }

    /**
     * Affiche la page d'ajout d'une STB
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ModelAndView insert() {

        ModelAndView model = new ModelAndView();
        model.setViewName("insert");

        return model;
    }

    /**
     * Ajoute une STB et l'envoie sur le serveurHeroku
     * @param req
     * @return
     */
    @RequestMapping(value = "/insertPost", method = RequestMethod.POST)
    public ModelAndView insertPost(HttpServletRequest req) {

        STB stb = new STB();

        if (!req.getParameter("titreProjet").equals("") && !req.getParameter("version").equals("") && !req.getParameter("description").equals("")) {
            stb.setTitreProjet(req.getParameter("titreProjet"));
            stb.setVersion(req.getParameter("version"));
            stb.setDescription(req.getParameter("description"));
        }

        if (!req.getParameter("date").equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
            String dateInString = req.getParameter("date");

            try {

                Date date = sdf.parse(dateInString);
                stb.setDate(date.toString());

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        Client client = new Client();
        if (!req.getParameter("client.entite").equals("") && !req.getParameter("client.contact").equals("") && !req.getParameter("client.codePostal").equals("")) {
            client.setEntite(req.getParameter("client.entite"));
            client.setContact(req.getParameter("client.contact"));
            client.setCodePostal(Integer.parseInt(req.getParameter("client.codePostal")));
            stb.setClient(client);
        }

        if (!req.getParameter("nb_equipe").equals("")){
            int nb_equipe = Integer.parseInt(req.getParameter("nb_equipe"));
            ArrayList<Equipe> equipes = new ArrayList<Equipe>();
            for (int i = 1; i <= nb_equipe; i++) {
                equipes.add(new Equipe(
                        Boolean.parseBoolean(req.getParameter("equipe" + i + ".gender")),
                        req.getParameter("equipe" + i + ".nom"),
                        req.getParameter("equipe" + i + ".prenom")
                ));
            }
            stb.setEquipeList(equipes);
        }
        if (!req.getParameter("nb_fct").equals("")) {
            int nb_fct = Integer.parseInt(req.getParameter("nb_fct"));

            List<Fonctionnalite> fcts = new ArrayList<Fonctionnalite>();
            for (int i = 1; i <= nb_fct; i++) {
                List<ExigenceFonctionnelle> efs = new ArrayList<ExigenceFonctionnelle>();

                int nb_ef = Integer.parseInt(req.getParameter("nb_ef" + i));
                for (int j = 1; j <= nb_ef; j++) {
                    ExigenceFonctionnelle ef = new ExigenceFonctionnelle();
                    ef.setIdentifiant(Integer.parseInt(req.getParameter("fonctionnalite" + i + ".ef" + j + ".identifiant")));
                    ef.setDescription(req.getParameter("fonctionnalite" + i + ".ef" + j + ".description"));
                    ef.setPriorite(Integer.parseInt(req.getParameter("fonctionnalite" + i + ".ef" + j + ".priorite")));
                    efs.add(ef);
                }
                Fonctionnalite fct = new Fonctionnalite(
                        req.getParameter("fonctionnalite" + i + ".description"),
                        Integer.parseInt(req.getParameter("fonctionnalite" + i + ".priorite")),
                        efs);
                fcts.add(fct);
            }
            stb.setFonctionnaliteList(fcts);
        }

        ModelAndView model = new ModelAndView();

        try {
            StringWriter sw = new StringWriter();
            JAXBContext jaxbContext = JAXBContext.newInstance(STB.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(stb, sw);
            model.addObject("xml_stb", sw.toString());

            String xmlString = sw.toString();;
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpRequest = new HttpPost("https://evening-dusk-58838.herokuapp.com/depot");

            httpRequest.setHeader("Content-Type", "application/xml");
            StringEntity xmlEntity = new StringEntity(xmlString);
            httpRequest.setEntity(xmlEntity );
            HttpResponse httpresponse = httpClient.execute(httpRequest);

            HttpEntity entity = httpresponse.getEntity();
            StringBuilder sb = new StringBuilder();
            // Controle des résultats du serveur
            try {
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(entity.getContent()), 65728);
                String line = null;

                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            }
            catch (IOException e) { e.printStackTrace(); }
            catch (Exception e) { e.printStackTrace(); }
            int rep = Integer.parseInt(sb.toString());

            if(rep == -1){
                ModelAndView retourne =new ModelAndView("redirect:/insert");
                retourne.addObject("erreur", "il a y une erreur dans la STB");
                return retourne;
            }else{
                return new ModelAndView("redirect:/resume/"+rep);
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    /**
     * Affiche toutes les STB
     *
     * @return
     */
    @RequestMapping(value = "/resume", method = RequestMethod.GET)
    public ModelAndView resume() {

        String url = "https://evening-dusk-58838.herokuapp.com/resume";

        ModelAndView model = new ModelAndView();
        try {

            JAXBContext jc = JAXBContext.newInstance(STBList.class);
            Unmarshaller u = jc.createUnmarshaller();
            StringReader sr = new StringReader(getXml(url));
            STBList list = (STBList) u.unmarshal(sr);
            model.addObject("stb_list", list.getSTBs());
            model.setViewName("resume");

            return model;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    /**
     * affiche une STB selon son ID
     *
     * @return
     */

    @RequestMapping(value = "/resume/{id:.+}", method = RequestMethod.GET)
    public ModelAndView resumeById(@PathVariable("id") int id) {

        String url = "https://evening-dusk-58838.herokuapp.com/resume/" + id;

        ModelAndView model = new ModelAndView();
        try {
            String xml = getXml(url);

            JAXBContext jc = JAXBContext.newInstance(STB.class);
            Unmarshaller u = jc.createUnmarshaller();
            StringReader sr = new StringReader(xml);

            STB stb = (STB) u.unmarshal(sr);
            model.addObject("stb", stb);
            model.setViewName("resume");

            return model;
        } catch (Exception e) {
            model.addObject("erreur", "Il n'y a pas de STB à l'id : "+id);
        }
        return model;

    }

    /**
     * récupère le XML de la l'url
     * @param urlToRead
     * @return
     * @throws Exception
     */
    public static String getXml(String urlToRead) throws Exception {

        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

}