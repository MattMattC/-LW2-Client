package com.lw2.web.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "stb")
@XmlAccessorType(XmlAccessType.NONE)
public class STBLight {

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
	
	public STBLight(int id, String titreProjet, String version, String date, String description) {
        this.id = id;
        this.titreProjet = titreProjet;
        this.version = version;
        this.date = date;
        this.description = description;
    }
	
	public STBLight(){
		
	}

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
	
	
	
}
