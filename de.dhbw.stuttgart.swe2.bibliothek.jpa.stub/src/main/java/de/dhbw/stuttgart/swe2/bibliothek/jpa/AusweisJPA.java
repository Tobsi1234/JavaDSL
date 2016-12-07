package de.dhbw.stuttgart.swe2.bibliothek.jpa;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import de.dhbw.stuttgart.swe2.bibliothek.Ausweis;
import de.dhbw.stuttgart.swe2.bibliothek.Kunde;

@Entity(name = "AUSWEIS")
public class AusweisJPA extends AbstractIdentifiable implements Ausweis {
	private Date gueltigkeit;

	@OneToOne (targetEntity = KundeJPA.class, cascade=CascadeType.ALL)
	private Kunde kunde;
	
	@Override
	public Date getGueltigkeit() {
		return gueltigkeit;
	}

	@Override
	public void setGueltigkeit(Date gueltigkeit) {
		this.gueltigkeit = gueltigkeit;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
}
