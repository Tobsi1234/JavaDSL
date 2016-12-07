package de.dhbw.stuttgart.swe2.bibliothek;

import java.util.List;

public interface Bibliothek {

	String getName();

	void setName(String name);

	String getStrasse();

	void setStrasse(String strasse);

	int getHausnr();

	void setHausnr(int hausnr);

	String getPlz();

	void setPlz(String plz);

	String getOrt();

	void setOrt(String ort);

	String getTelefonnr();

	void setTelefonnr(String telefonnr);

	List<Mitarbeiter> getMitarbeiter();

	void setMitarbeiter(List<Mitarbeiter> mitarbeiter);

	List<Ausleihobjekt> getAusleihobjekte();

	void setAusleihobjekte(List<Ausleihobjekt> ausleihobjekte);

}