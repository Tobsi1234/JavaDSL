package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import de.dhbw.stuttgart.swe2.bibliothek.Ausleihinformation;
import de.dhbw.stuttgart.swe2.bibliothek.Ausleihobjekt;
import de.dhbw.stuttgart.swe2.bibliothek.Kunde;
import de.dhbw.stuttgart.swe2.bibliothek.Mitarbeiter;

@Entity(name = "AUSLEIHINFORMATION")
public class AusleihinformationJPA extends AbstractIdentifiable implements Ausleihinformation {

	private Date ausleihdatum;
	private Date planRueckgabe;
	private Date rueckgabe;
	private double strafzahlung;
	private String zustand;
	
	@ManyToOne (targetEntity = AusleihobjektJPA.class, cascade=CascadeType.ALL)
	private Ausleihobjekt ausleihobjekt;
	
	@ManyToOne (targetEntity = MitarbeiterJPA.class, cascade=CascadeType.ALL)
	private Mitarbeiter mitarbeiter;
	
	@ManyToOne (targetEntity = KundeJPA.class, cascade=CascadeType.ALL)
	private Kunde kunde;

	@Override
	public Date getAusleihdatum() {
		return ausleihdatum;
	}

	@Override
	public void setAusleihdatum(Date ausleihdatum) {
		this.ausleihdatum = ausleihdatum;
	}

	@Override
	public Date getPlanRueckgabe() {
		return planRueckgabe;
	}

	@Override
	public void setPlanRueckgabe(Date planRueckgabe) {
		this.planRueckgabe = planRueckgabe;
	}

	@Override
	public Date getRueckgabe() {
		return rueckgabe;
	}

	@Override
	public void setRueckgabe(Date rueckgabe) {
		this.rueckgabe = rueckgabe;
	}

	@Override
	public double getStrafzahlung() {
		return strafzahlung;
	}

	@Override
	public void setStrafzahlung(double strafzahlung) {
		this.strafzahlung = strafzahlung;
	}

	@Override
	public String getZustand() {
		return zustand;
	}

	@Override
	public void setZustand(String zustand) {
		this.zustand = zustand;
	}

	@Override
	public Ausleihobjekt getAusleihobjekt() {
		return ausleihobjekt;
	}

	@Override
	public void setAusleihobjekt(Ausleihobjekt ausleihobjekt) {
		this.ausleihobjekt = ausleihobjekt;
	}

	@Override
	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}

	@Override
	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	@Override
	public Kunde getKunde() {
		return kunde;
	}

	@Override
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

}
