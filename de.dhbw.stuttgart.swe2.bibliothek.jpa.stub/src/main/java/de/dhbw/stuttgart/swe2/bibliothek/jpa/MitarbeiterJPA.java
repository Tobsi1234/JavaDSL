package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import de.dhbw.stuttgart.swe2.bibliothek.Ausleihinformation;
import de.dhbw.stuttgart.swe2.bibliothek.Bibliothek;
import de.dhbw.stuttgart.swe2.bibliothek.Mitarbeiter;

@Entity (name = "MITARBEITER")
public class MitarbeiterJPA extends MenschJPA implements Mitarbeiter {
	
	private int personalnr;
	private double gehalt;
	
	@OneToMany(targetEntity = AusleihinformationJPA.class, cascade=CascadeType.ALL, mappedBy="mitarbeiter")
	private List<Ausleihinformation> ausleihinfos;

	@ManyToOne(targetEntity = BibliothekJPA.class, cascade=CascadeType.ALL)
	private Bibliothek bibliothek;

	@Override
	public int getPersonalnr() {
		return personalnr;
	}

	@Override
	public void setPersonalnr(int personalnr) {
		this.personalnr = personalnr;
	}

	@Override
	public double getGehalt() {
		return gehalt;
	}

	@Override
	public void setGehalt(double gehalt) {
		this.gehalt = gehalt;
	}

	@Override
	public List<Ausleihinformation> getAusleihinfos() {
		return ausleihinfos;
	}

	@Override
	public void setAusleihinfos(List<Ausleihinformation> ausleihinfos) {
		this.ausleihinfos = ausleihinfos;
	}
	
	@Override
	public Bibliothek getBibliothek() {
		return bibliothek;
	}

	@Override
	public void setBibliothek(Bibliothek bibliothek) {
		this.bibliothek = bibliothek;
	}

}
