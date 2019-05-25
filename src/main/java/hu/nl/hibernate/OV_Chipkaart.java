package hu.nl.hibernate;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OV_Chipkaart {

	@Id
	@GeneratedValue
	private int kaartNummer;
	private Date geldigTot;
	private int klasse;
	private double saldo;
	private int reizigerid;
	
	@ManyToOne
	@JoinColumn(name="reizigerid")
	private Reiziger r;
	
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
	
	public Reiziger getReiziger() {
		return this.r;
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
	
	public void setReiziger(Reiziger r) {
		this.r = r;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	
	public String toString() {
		return "Kaart nummer: " + this.kaartNummer + " is geldig tot: " + this.geldigTot + " en heeft klasse: " + this.klasse
				+ " heeft een saldo van: " + this.saldo + ", en het reizigerid van deze kaart is: " + this.reizigerid;

	}

}
