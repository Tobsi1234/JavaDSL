package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import de.dhbw.stuttgart.swe2.bibliothek.Ausleihobjekt;
import de.dhbw.stuttgart.swe2.bibliothek.Herausgeber;
import de.dhbw.stuttgart.swe2.bibliothek.Objektinformation;

@Entity (name = "OBJEKTINFORMATION")
public class ObjektinformationJPA extends AbstractIdentifiable implements Objektinformation {

	private String name;

	@OneToMany (targetEntity = AusleihobjektJPA.class, cascade=CascadeType.ALL)
	private List<Ausleihobjekt> ausleihobjekte;
	
	@ManyToMany (targetEntity = HerausgeberJPA.class, cascade=CascadeType.ALL)
	private List<Herausgeber> herausgeber;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public List<Ausleihobjekt> getAusleihobjekte() {
		return ausleihobjekte;
	}

	@Override
	public void setAusleihobjekte(List<Ausleihobjekt> ausleihobjekte) {
		this.ausleihobjekte = ausleihobjekte;
	}

	@Override
	public List<Herausgeber> getHerausgeber() {
		return herausgeber;
	}

	@Override
	public void setHerausgeber(List<Herausgeber> herausgeber) {
		this.herausgeber = herausgeber;
	}


}
