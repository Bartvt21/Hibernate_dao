package hu.nl.hibernate;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reiziger {
	
	@Id
	@GeneratedValue
	private int reizigerid;
	
	private String voorl;
	private String tussenvoegsel;
	private String achternaam;
	private Date gbdatum;
	
	@OneToMany(targetEntity=OV_Chipkaart.class, mappedBy="r", cascade=CascadeType.ALL)
	ArrayList<OV_Chipkaart> mijnOv;
	
	public Reiziger(int reizigerid, String voorl, String tussenvoegsel, String achternaam, String datum) {
		this.reizigerid = reizigerid;
		this.voorl = voorl;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gbdatum = Date.valueOf(datum);
		mijnOv = new ArrayList<OV_Chipkaart>();
	}
	
	public String getVoorl() {
		return voorl;
	}
	
	public String getTussenvoel() {
		return tussenvoegsel;
	}
	
	public String getAchternaam() {
		return achternaam;
	}

	public int getReizigerid() {
		return reizigerid;
	}
	
	public void setReizigerid(int id) {
		this.reizigerid = id;
	}
	
	public Date getGBdatum() {
		return gbdatum;
	}
	
	public void setVoorl(String voorl) {
		this.voorl = voorl;
	} 
	
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	
	public void setGBdatum(Date datum) {
		this.gbdatum = datum;
	}
	
	public String getNaam() {
		return voorl + " " + tussenvoegsel + " " + achternaam;
	}
	
	public ArrayList<OV_Chipkaart> getOV_Chipkaart() {
		return this.mijnOv;
	}
	
	public void saveOvChipkaart(OV_Chipkaart kaart) {
		if(!(this.mijnOv.contains(kaart))) {
			this.mijnOv.add(kaart);
		}
	}
	
	public String toString() {
		String s = "Reiziger: " + this.voorl + " " + this.tussenvoegsel + " " + this.achternaam + " heeft geboortedatum: " + this.getGBdatum() + "\n";
	
		return s;
	}
}
