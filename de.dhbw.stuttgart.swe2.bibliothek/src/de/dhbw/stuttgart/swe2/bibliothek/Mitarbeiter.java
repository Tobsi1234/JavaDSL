package de.dhbw.stuttgart.swe2.bibliothek;

import java.util.List;

public interface Mitarbeiter {

	int getPersonalnr();

	void setPersonalnr(int personalnr);

	double getGehalt();

	void setGehalt(double gehalt);

	List<Ausleihinformation> getAusleihinfos();

	void setAusleihinfos(List<Ausleihinformation> ausleihinfos);

	public Bibliothek getBibliothek();
	
	public void setBibliothek(Bibliothek bibliothek);

}