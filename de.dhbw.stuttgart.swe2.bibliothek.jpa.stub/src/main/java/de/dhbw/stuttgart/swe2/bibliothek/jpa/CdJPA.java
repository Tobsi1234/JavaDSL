package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import de.dhbw.stuttgart.swe2.bibliothek.Cd;
import de.dhbw.stuttgart.swe2.bibliothek.Titel;

@Entity(name = "CD")
public class CdJPA extends MultimediamedienJPA implements Cd {

	private int anzahlTitel;
	
	@ManyToMany(targetEntity = TitelJPA.class)
	private List<Titel> titel;

	@Override
	public int getAnzahlTitel() {
		return anzahlTitel;
	}

	@Override
	public void setAnzahlTitel(int anzahlTitel) {
		this.anzahlTitel = anzahlTitel;
	}

	@Override
	public List<Titel> getTitel() {
		return titel;
	}
	
	@Override
	public void setTitel(List<Titel> titel) {
		this.titel = titel;
	}
}
