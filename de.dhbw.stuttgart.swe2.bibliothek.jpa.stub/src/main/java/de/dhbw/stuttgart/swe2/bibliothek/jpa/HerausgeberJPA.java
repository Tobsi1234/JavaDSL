package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import de.dhbw.stuttgart.swe2.bibliothek.Herausgeber;
import de.dhbw.stuttgart.swe2.bibliothek.Objektinformation;

@Entity (name = "HERAUSGEBER")
public class HerausgeberJPA extends AbstractIdentifiable implements Herausgeber {

	private String name;
	
	@ManyToMany(targetEntity = ObjektinformationJPA.class, mappedBy = "herausgeber")
	private List<Objektinformation> objektinfos;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public List<Objektinformation> getObjektinfos() {
		return objektinfos;
	}

	@Override
	public void setObjektinfos(List<Objektinformation> objektinfos) {
		this.objektinfos = objektinfos;
	}
	
}
