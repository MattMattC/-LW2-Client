package com.lw2.web.model;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name="stbs")
public class STBList implements Serializable 
{    
	@XmlElement(name="stb")
    private ArrayList<STBLight> stbs = new ArrayList<STBLight>();
 
    public ArrayList<STBLight> getSTBs() {
        return stbs;
    }
 
    public void setEmployees(ArrayList<STBLight> stbs) {
        this.stbs = stbs;
    }
}
