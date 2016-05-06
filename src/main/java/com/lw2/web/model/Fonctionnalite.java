package com.lw2.web.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Equipe")
@XmlAccessorType(XmlAccessType.NONE)
public class Fonctionnalite {

    @XmlElement
    private String description;
    
    @XmlAttribute
    private int priorite;

    @XmlElement(name = "ef")
    private List<ExigenceFonctionnelle> listExigenceFonctionnelle;

    public Fonctionnalite(String description, int priorite, List<ExigenceFonctionnelle> listExigenceFonctionnelle){
    	this.description = description;
    	this.priorite = priorite;
    	this.listExigenceFonctionnelle = listExigenceFonctionnelle;
    }
    
    public Fonctionnalite() {
    	listExigenceFonctionnelle = new ArrayList<ExigenceFonctionnelle>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getPriorite(){
    	return priorite;
    }
    
    public void setPriorite(int priorite){
    	this.priorite = priorite;
    }

    public List<ExigenceFonctionnelle> getExigenceFonctionnelle() {
        return listExigenceFonctionnelle;
    }

    public void setExigenceFonctionnelle(List<ExigenceFonctionnelle> listExigenceFonctionnelle) {
        this.listExigenceFonctionnelle = listExigenceFonctionnelle;
    }
}
