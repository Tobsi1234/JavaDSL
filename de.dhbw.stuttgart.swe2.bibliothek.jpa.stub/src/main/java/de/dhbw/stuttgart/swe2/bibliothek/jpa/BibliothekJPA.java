package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import de.dhbw.stuttgart.swe2.bibliothek.Ausleihobjekt;
import de.dhbw.stuttgart.swe2.bibliothek.Bibliothek;
import de.dhbw.stuttgart.swe2.bibliothek.Mitarbeiter;

@Entity(name = "BIBLIOTHEK")
public class BibliothekJPA extends AbstractIdentifiable implements Bibliothek {

	private String name;
	private String strasse;
	private int hausnr;
	private String plz;
	private String ort;
	private String telefonnr;

	@OneToMany(targetEntity = MitarbeiterJPA.class, cascade=CascadeType.ALL)
	private List<Mitarbeiter> mitarbeiter;

	@ManyToMany(targetEntity = AusleihobjektJPA.class)
	private List<Ausleihobjekt> ausleihobjekte;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
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
	public String getTelefonnr() {
		return telefonnr;
	}

	@Override
	public void setTelefonnr(String telefonnr) {
		this.telefonnr = telefonnr;
	}

	@Override
	public List<Mitarbeiter> getMitarbeiter() {
		return mitarbeiter;
	}

	@Override
	public void setMitarbeiter(List<Mitarbeiter> mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	@Override
	public List<Ausleihobjekt> getAusleihobjekte() {
		return ausleihobjekte;
	}

	@Override
	public void setAusleihobjekte(List<Ausleihobjekt> ausleihobjekte) {
		this.ausleihobjekte = ausleihobjekte;
	}
}
