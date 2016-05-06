package com.lw2.web.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Equipe")
@XmlAccessorType(XmlAccessType.NONE)
public class ExigenceFonctionnelle {

    @XmlElement
    private int identifiant;

    @XmlElement
    private String description;

    @XmlAttribute
    private int priorite;
    
    public ExigenceFonctionnelle(int identifiant, String description, int priorite){
    	this.identifiant = identifiant;
    	this.description = description;
    	this.priorite = priorite;
    }
    
    public ExigenceFonctionnelle(){
    	
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }
}
