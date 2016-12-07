package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import javax.persistence.Entity;

import de.dhbw.stuttgart.swe2.bibliothek.Printmedien;

@Entity (name = "PRINTMEDIEN")
public class PrintmedienJPA extends ObjektinformationJPA implements Printmedien {
	
	private int seitenzahl;

	@Override
	public int getSeitenzahl() {
		return seitenzahl;
	}

	@Override
	public void setSeitenzahl(int seitenzahl) {
		this.seitenzahl = seitenzahl;
	}
	
}
