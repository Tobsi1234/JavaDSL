package de.dhbw.stuttgart.swe2.bibliothek;

import java.util.List;

public interface Kunde {

	boolean isAktiv();

	void setAktiv(boolean aktiv);

	List<Ausleihinformation> getAusleihinfos();

	void setAusleihinfos(List<Ausleihinformation> ausleihinfos);

	Ausweis getAusweis();

	void setAusweis(Ausweis ausweis);

}