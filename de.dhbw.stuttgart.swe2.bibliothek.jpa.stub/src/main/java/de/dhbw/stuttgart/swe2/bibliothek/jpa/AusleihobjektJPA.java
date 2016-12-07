package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import de.dhbw.stuttgart.swe2.bibliothek.Ausleihinformation;
import de.dhbw.stuttgart.swe2.bibliothek.Ausleihobjekt;
import de.dhbw.stuttgart.swe2.bibliothek.Bibliothek;
import de.dhbw.stuttgart.swe2.bibliothek.Objektinformation;

@Entity (name = "AUSLEIHOBJEKT")
public class AusleihobjektJPA extends AbstractIdentifiable implements Ausleihobjekt {

	@OneToMany(targetEntity = AusleihinformationJPA.class, cascade=CascadeType.ALL)
	private List<Ausleihinformation> ausleihinfos;
	
	@ManyToMany(targetEntity = BibliothekJPA.class)
	private List<Bibliothek> bibliotheken;
	
	@ManyToOne (targetEntity = ObjektinformationJPA.class, cascade=CascadeType.ALL)
	private Objektinformation objektinformation;

	@Override
	public List<Ausleihinformation> getAusleihinfos() {
		return ausleihinfos;
	}

	@Override
	public void setAusleihinfos(List<Ausleihinformation> ausleihinfos) {
		this.ausleihinfos = ausleihinfos;
	}

	@Override
	public List<Bibliothek> getBibliotheken() {
		return bibliotheken;
	}

	@Override
	public void setBibliotheken(List<Bibliothek> bibliotheken) {
		this.bibliotheken = bibliotheken;
	}

	@Override
	public Objektinformation getObjektinformation() {
		return objektinformation;
	}

	@Override
	public void setObjektinformation(Objektinformation objektinformation) {
		this.objektinformation = objektinformation;
	}
	
}
