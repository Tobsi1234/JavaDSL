package de.dhbw.stuttgart.swe2.bibliothek;

import java.util.Date;

public interface Mensch {

	Date getGeburtsdatum();

	void setGeburtsdatum(Date geburtsdatum);

	String getName();

	void setName(String name);

	String getVorname();

	void setVorname(String vorname);

	String getStrasse();

	void setStrasse(String strasse);

	int getHausnr();

	void setHausnr(int hausnr);

	String getPlz();

	void setPlz(String plz);

	String getOrt();

	void setOrt(String ort);

	char getGeschlecht();

	void setGeschlecht(char geschlecht);

}