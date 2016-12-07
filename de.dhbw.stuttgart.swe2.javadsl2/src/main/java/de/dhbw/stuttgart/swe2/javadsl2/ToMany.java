package de.dhbw.stuttgart.swe2.javadsl2;

import java.util.List;

public interface ToMany<Input, Output> {
	
	String get();

	String getEntityName();

	String getEntityKey();

}
