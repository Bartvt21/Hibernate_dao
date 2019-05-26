package hu.nl.hibernate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity  
@Table(name= "REIZIGER") 
public class Reiziger {
	
	@Id   
	private int reizigerid;
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private Date gebortedatum;
	
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name="REIZIGERID")  
	private List<OV_Chipkaart> mijnKaarten;
	
	public Reiziger() {
		
	}
	
	public Reiziger(int reizigerid, String voorl, String tussenvoegsel, String achternaam, String datum) {
		this.reizigerid = reizigerid;
		this.voorletters = voorl;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gebortedatum = Date.valueOf(datum);
		mijnKaarten = new ArrayList<OV_Chipkaart>();
	}
	
	public String getVoorl() {
		return voorletters;
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
		return gebortedatum;
	}
	
	public void setVoorl(String voorl) {
		this.voorletters = voorl;
	} 
	
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	
	public void setGBdatum(Date datum) {
		this.gebortedatum = datum;
	}
	
	public List<OV_Chipkaart> setKaart(OV_Chipkaart kaart) {
		
		
		if(!(this.mijnKaarten.contains(kaart))) {
			this.mijnKaarten.add(kaart);
		}
		
		return this.mijnKaarten;
	}
	
	public List<OV_Chipkaart> getMijnKaarten() {
		return this.mijnKaarten;
	} 
	
	
	public String toString() {
		return this.voorletters + " " + this.tussenvoegsel + " " + this.achternaam + " heeft reizigerid: " + this.reizigerid + " en heeft ovkaart: " + this.mijnKaarten;
	}

	
}
