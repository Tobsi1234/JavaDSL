package de.dhbw.stuttgart.swe2.bibliothek;

import java.util.List;

public interface Herausgeber {

	String getName();

	void setName(String name);

	List<Objektinformation> getObjektinfos();

	void setObjektinfos(List<Objektinformation> objektinfos);

}