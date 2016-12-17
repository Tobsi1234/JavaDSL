package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import de.dhbw.stuttgart.swe2.bibliothek.Artist;
import de.dhbw.stuttgart.swe2.bibliothek.Cd;
import de.dhbw.stuttgart.swe2.bibliothek.Titel;

@Entity (name = "TITEL")
public class TitelJPA extends AbstractIdentifiable implements Titel {

	private String name;
	private int dauer;
	
	@ManyToMany(targetEntity = CdJPA.class, mappedBy="titel")
	private List<Cd> cds;
	
	@ManyToMany(targetEntity = ArtistJPA.class)
	private List<Artist> artists;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getDauer() {
		return dauer;
	}

	@Override
	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	@Override
	public List<Cd> getCds() {
		return cds;
	}

	@Override
	public void setCds(List<Cd> cds) {
		this.cds = cds;
	}

	@Override
	public List<Artist> getArtists() {
		return artists;
	}

	@Override
	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}
}
