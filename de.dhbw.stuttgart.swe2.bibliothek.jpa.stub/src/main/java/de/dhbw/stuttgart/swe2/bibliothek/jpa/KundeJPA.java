package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import de.dhbw.stuttgart.swe2.bibliothek.Ausleihinformation;
import de.dhbw.stuttgart.swe2.bibliothek.Ausweis;
import de.dhbw.stuttgart.swe2.bibliothek.Kunde;

@Entity (name = "KUNDE")
public class KundeJPA extends MenschJPA implements Kunde {

	private boolean aktiv;
	
	@OneToMany (targetEntity = AusleihinformationJPA.class, cascade=CascadeType.ALL, mappedBy="kunde")
	private List<Ausleihinformation> ausleihinfos;
	
	@OneToOne (targetEntity = AusweisJPA.class, cascade=CascadeType.ALL)
	private Ausweis ausweis;

	@Override
	public boolean isAktiv() {
		return aktiv;
	}

	@Override
	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}

	@Override
	public List<Ausleihinformation> getAusleihinfos() {
		return ausleihinfos;
	}

	@Override
	public void setAusleihinfos(List<Ausleihinformation> ausleihinfos) {
		this.ausleihinfos = ausleihinfos;
	}

	@Override
	public Ausweis getAusweis() {
		return ausweis;
	}

	@Override
	public void setAusweis(Ausweis ausweise) {
		this.ausweis = ausweise;
	}
}
