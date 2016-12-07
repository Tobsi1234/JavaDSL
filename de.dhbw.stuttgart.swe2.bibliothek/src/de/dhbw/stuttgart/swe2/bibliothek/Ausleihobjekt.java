package de.dhbw.stuttgart.swe2.bibliothek;

import java.util.List;

public interface Ausleihobjekt {

	List<Ausleihinformation> getAusleihinfos();

	void setAusleihinfos(List<Ausleihinformation> ausleihinfos);

	List<Bibliothek> getBibliotheken();

	void setBibliotheken(List<Bibliothek> bibliotheken);

	Objektinformation getObjektinformation();

	void setObjektinformation(Objektinformation objektinformation);

}