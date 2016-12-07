package de.dhbw.stuttgart.swe2.bibliothek;

import java.util.List;

public interface Cd {

	int getAnzahlTitel();

	void setAnzahlTitel(int anzahlTitel);

	List<Titel> getTitel();

	void setTitel(List<Titel> titel);

}