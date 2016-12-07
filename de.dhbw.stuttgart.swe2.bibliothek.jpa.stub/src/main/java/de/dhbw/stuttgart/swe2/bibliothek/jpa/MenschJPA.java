package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import de.dhbw.stuttgart.swe2.bibliothek.Mensch;

@MappedSuperclass
public class MenschJPA extends AbstractIdentifiable implements Mensch {

	private Date geburtsdatum;
	private String name;
	private String vorname;
	private String strasse;
	private int hausnr;
	private String plz;
	private String ort;
	private char geschlecht;
	
	@Override
	public Date getGeburtsdatum() {
		return geburtsdatum;
	}
	@Override
	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getVorname() {
		return vorname;
	}
	@Override
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	@Override
	public String getStrasse() {
		return strasse;
	}
	@Override
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	@Override
	public int getHausnr() {
		return hausnr;
	}
	@Override
	public void setHausnr(int hausnr) {
		this.hausnr = hausnr;
	}
	@Override
	public String getPlz() {
		return plz;
	}
	@Override
	public void setPlz(String plz) {
		this.plz = plz;
	}
	@Override
	public String getOrt() {
		return ort;
	}
	@Override
	public void setOrt(String ort) {
		this.ort = ort;
	}
	@Override
	public char getGeschlecht() {
		return geschlecht;
	}
	@Override
	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht;
	}
	
}
