package com.lw2.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement (name = "stb")
@XmlAccessorType(XmlAccessType.NONE)
public class STB implements Serializable 
{
	private static int STB_ID = 0;

    @XmlElement
    private int id;
	
	@XmlElement
	private String titreProjet;
	
	@XmlElement
	private String version;
	
	@XmlElement
	private String date;
	
	@XmlElement
	private String description;
    
    @XmlElement
    private Client client;
    
    @XmlElement(name="equipe")
    private List<Equipe> equipeList;
    
    @XmlElement(name="fonctionnalite")
    private List<Fonctionnalite> fonctionnaliteList;
     
    public STB(String titreProjet, String version, String date, String description,Client client,
    		List<Equipe> equipeList, List<Fonctionnalite> fonctionnaliteList) {
        super();
        this.titreProjet = titreProjet;
        this.version = version;
        this.date = date;
        this.description = description;
        this.client = client;
        this.equipeList = equipeList;
        this.fonctionnaliteList = fonctionnaliteList;
    }
     
    public STB(){
    	this.equipeList = new ArrayList<Equipe>();
    	this.fonctionnaliteList = new ArrayList<Fonctionnalite>();
    }

    
    //Setters and Getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitreProjet() {
		return titreProjet;
	}

	public void setTitreProjet(String titreProjet) {
		this.titreProjet = titreProjet;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Equipe> getEquipeList() {
		return equipeList;
	}

	public void setEquipeList(List<Equipe> equipeList) {
		this.equipeList = equipeList;
	}
	
	public List<Fonctionnalite> getFonctionnaliteList() {
		return fonctionnaliteList;
	}

	public void setFonctionnaliteList(List<Fonctionnalite> fonctionnaliteList) {
		this.fonctionnaliteList = fonctionnaliteList;
	}

	

}