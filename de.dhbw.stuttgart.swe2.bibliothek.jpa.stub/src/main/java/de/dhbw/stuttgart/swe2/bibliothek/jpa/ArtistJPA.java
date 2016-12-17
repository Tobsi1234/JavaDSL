package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import de.dhbw.stuttgart.swe2.bibliothek.Artist;
import de.dhbw.stuttgart.swe2.bibliothek.Titel;

@Entity (name = "ARTIST")
public class ArtistJPA extends AbstractIdentifiable implements Artist{

	private String name;
	
	@ManyToMany(targetEntity = TitelJPA.class, mappedBy="artists")
	private List<Titel> titel;

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public List<Titel> getTitel() {
		return titel;
	}

	@Override
	public void setTitel(List<Titel> titel) {
		this.titel = titel;
	}
}
