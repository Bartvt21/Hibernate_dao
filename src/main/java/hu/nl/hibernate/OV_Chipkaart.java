package hu.nl.hibernate;

import java.sql.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity  
@Table(name= "OV_CHIPKAART") 
public class OV_Chipkaart {

	@Id 
	private int kaartNummer;
	private Date geldigTot;
	private int klasse;
	private double saldo;
	private int reizigerid;
	
	
	public OV_Chipkaart() {
		
	}
	
	public OV_Chipkaart(int kaartNummer, String geldigTot, int klasse, double saldo, int reizigerid) {
		this.kaartNummer = kaartNummer;
		this.geldigTot = Date.valueOf(geldigTot);
		this.klasse = klasse;
		this.saldo = saldo;
		this.reizigerid = reizigerid;
	}
	
	public Date getGeldigTot() {
		return geldigTot;
	}
	
	public int getKlasse() {
		return klasse;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public int getKaartNummer() {
		return kaartNummer;
	}

	public void setGeldigTot(Date datum) {
		this.geldigTot = datum;
	}
	
	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}
	
	public int getReizigerId() {
		return this.reizigerid;
	}
	
	
	public String toString() {
		return this.kaartNummer + " heeft een saldo van : " + this.saldo + " heeft een reiziger: " + this.reizigerid;
	}


}
