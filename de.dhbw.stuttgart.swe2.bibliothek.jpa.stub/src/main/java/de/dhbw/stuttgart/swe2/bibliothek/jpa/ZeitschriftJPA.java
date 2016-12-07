package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import javax.persistence.Entity;

import de.dhbw.stuttgart.swe2.bibliothek.Zeitschrift;

@Entity (name = "ZEITSCHRIFT")
public class ZeitschriftJPA extends PrintmedienJPA implements Zeitschrift {
	private String ausgabe;

	@Override
	public String getAusgabe() {
		return ausgabe;
	}

	@Override
	public void setAusgabe(String ausgabe) {
		this.ausgabe = ausgabe;
	}
}
