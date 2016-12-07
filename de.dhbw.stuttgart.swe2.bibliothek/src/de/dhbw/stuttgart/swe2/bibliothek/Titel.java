package de.dhbw.stuttgart.swe2.bibliothek;

import java.util.List;

public interface Titel {

	String getName();

	void setName(String name);

	int getDauer();

	void setDauer(int dauer);

	List<Cd> getCds();

	void setCds(List<Cd> cds);

	List<Artist> getArtists();

	void setArtists(List<Artist> artists);

}