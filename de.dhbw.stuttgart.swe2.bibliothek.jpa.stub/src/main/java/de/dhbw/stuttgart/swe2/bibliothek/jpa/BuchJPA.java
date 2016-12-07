package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import javax.persistence.Entity;

import de.dhbw.stuttgart.swe2.bibliothek.Buch;

@Entity (name = "BUCH")
public class BuchJPA extends PrintmedienJPA implements Buch {
	private long isbn;
	private double auflage;
	
	@Override
	public long getIsbn() {
		return isbn;
	}
	@Override
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	@Override
	public double getAuflage() {
		return auflage;
	}
	@Override
	public void setAuflage(double auflage) {
		this.auflage = auflage;
	}
}
