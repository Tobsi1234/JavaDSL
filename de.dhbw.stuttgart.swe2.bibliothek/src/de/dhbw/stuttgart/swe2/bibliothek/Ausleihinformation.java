package de.dhbw.stuttgart.swe2.bibliothek;

import java.util.Date;

public interface Ausleihinformation {

	Date getAusleihdatum();

	void setAusleihdatum(Date ausleihdatum);

	Date getPlanRueckgabe();

	void setPlanRueckgabe(Date planRueckgabe);

	Date getRueckgabe();

	void setRueckgabe(Date rueckgabe);

	double getStrafzahlung();

	void setStrafzahlung(double strafzahlung);

	String getZustand();

	void setZustand(String zustand);

	Ausleihobjekt getAusleihobjekt();

	void setAusleihobjekt(Ausleihobjekt ausleihobjekt);

	Mitarbeiter getMitarbeiter();

	void setMitarbeiter(Mitarbeiter mitarbeiter);

	Kunde getKunde();

	void setKunde(Kunde kunde);

}