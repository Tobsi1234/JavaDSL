package de.dhbw.stuttgart.swe2.bibliothek;

import java.util.List;

public interface Objektinformation {

	String getName();

	void setName(String name);

	List<Ausleihobjekt> getAusleihobjekte();

	void setAusleihobjekte(List<Ausleihobjekt> ausleihobjekte);

	List<Herausgeber> getHerausgeber();

	void setHerausgeber(List<Herausgeber> herausgeber);

}