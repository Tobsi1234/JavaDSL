package de.dhbw.stuttgart.swe2.javadsl2;

public interface ToMany<Input, Output> {
	
	String get();

	String getEntityName();

	String getEntityKey();

	String get(Select select);
	
}
