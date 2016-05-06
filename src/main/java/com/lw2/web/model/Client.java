package com.lw2.web.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement (name = "client")
@XmlAccessorType(XmlAccessType.NONE)
public class Client {
	
	@XmlElement
	private String entite;
	
	@XmlElement
	private String contact;
	
	@XmlElement
	private int codePostal;
	
	public Client(String entite, String contact, int codePostal) {
        super();
        this.entite = entite;
        this.contact = contact;
        this.codePostal = codePostal;
    }
     
    public Client(){
         
    }
 
    //Setters and Getters
    public String getEntite(){
    	return entite;
    }
    
    public void setEntite(String entite){
    	this.entite = entite;
    }
    
    public String getContact(){
    	return this.contact;
    }
    
    public void setContact(String contact){
    	this.contact = contact;
    }
    
    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String toString(){
        return "[ "+getEntite()+" - "+getContact()+" - "+getCodePostal()+" ]";
    }
}
