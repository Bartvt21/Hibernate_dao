package hu.nl.hibernate;

public class Reiziger {
	
	private int id;
	private String naam;
	private String achternaam;
	
	public Reiziger() {
		
	}
	
	public Reiziger(int id, String nm, String achternaam) {
		this.id = id;
		this.naam = nm;
		this.achternaam = achternaam;
	}
	
	public int getReizigerId() {
		return this.id;
	}
	
	public String getNaam() {
		return this.naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	} 
	
	public String getAchternaam() {
		return this.achternaam;
	}
	
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	
	public String toString() {
		return "Reiziger: " + this.naam + " met achternaam: " + this.achternaam;
	}
}
