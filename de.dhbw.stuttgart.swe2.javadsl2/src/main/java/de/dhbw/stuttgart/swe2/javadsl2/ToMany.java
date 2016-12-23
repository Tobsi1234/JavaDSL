package de.dhbw.stuttgart.swe2.javadsl2;

public interface ToMany<Input, Output> {
	
	String get();

	String getEntityName();

	String getEntityKey();

	/**
	 * Gibt JPA String zurück. Nach dem "select" steht der Key der übergebenen Entity. 
	 * Sollte Entity nicht im JPA Statement vorkommen, wird der Key der From-Entity ("abc") genommen.
	 * 
	 * @param  select die Entity die selektiert werden soll
	 * 
	 * @return		  JPA String
	 */
	String get(Select select);

	ToMany<Input, Output> attribute(String attribute);

	ToMany<Input, Output> equals(String value);
	
	ToMany<Input, Output> lower(String value);

	ToMany<Input, Output> upper(String value);
	
	String getAttribute();
	
	String getOperator();
	
	String getValue();
	
}
