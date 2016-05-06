package com.lw2.web.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement (name = "equipe")
@XmlAccessorType(XmlAccessType.NONE)
public class Equipe {

	@XmlElement
    private boolean gender;
	
	@XmlElement
    private String nom;

    @XmlElement
    private String prenom;

    public Equipe(boolean gender, String nom, String prenom){
    	this.gender = gender;
    	this.nom = nom;
    	this.prenom = prenom;
    }

    public Equipe(){
    	
    }
    
    //Setters and Getters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
	
}
