package de.dhbw.stuttgart.swe2.bibliothek;

import java.util.List;

public interface Artist {

	String getName();

	void setName(String name);

	List<Titel> getTitel();

	public void setTitel(List<Titel> titel);
	
}