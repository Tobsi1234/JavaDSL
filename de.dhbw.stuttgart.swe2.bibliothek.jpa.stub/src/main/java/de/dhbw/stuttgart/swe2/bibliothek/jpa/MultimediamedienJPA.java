package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import javax.persistence.Entity;

import de.dhbw.stuttgart.swe2.bibliothek.Multimediamedien;

@Entity(name = "MULTIMEDIA")
public class MultimediamedienJPA extends ObjektinformationJPA implements Multimediamedien {

	private int anzahlDisks;
	private String genre;
	private int dauer;
	
	@Override
	public int getAnzahlDisks() {
		return anzahlDisks;
	}
	@Override
	public void setAnzahlDisks(int anzahlDisks) {
		this.anzahlDisks = anzahlDisks;
	}
	@Override
	public String getGenre() {
		return genre;
	}
	@Override
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public int getDauer() {
		return dauer;
	}
	@Override
	public void setDauer(int dauer) {
		this.dauer = dauer;
	}
	
	
}
