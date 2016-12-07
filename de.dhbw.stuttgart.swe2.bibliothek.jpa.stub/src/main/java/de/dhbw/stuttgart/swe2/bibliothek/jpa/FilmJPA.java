package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import javax.persistence.Entity;

import de.dhbw.stuttgart.swe2.bibliothek.Film;

@Entity(name = "FILM")
public class FilmJPA extends MultimediamedienJPA implements Film {
	private String typ;

	@Override
	public String getTyp() {
		return typ;
	}

	@Override
	public void setTyp(String typ) {
		this.typ = typ;
	}
}
