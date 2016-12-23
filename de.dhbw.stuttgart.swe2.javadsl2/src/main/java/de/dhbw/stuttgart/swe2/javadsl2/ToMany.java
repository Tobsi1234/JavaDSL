package de.dhbw.stuttgart.swe2.javadsl2;

public interface ToMany<Input, Output> {
	
	/**
	 * Gibt JPA String zurück. Nach dem "select" steht immer "abc" als Key der ersten Entity.
	 * 
	 * @return JPA String
	 */
	String get();

	/**
	 * Gibt den Namen der Entity zurück, Bsp: "bibliothek".
	 * 
	 * @return entityName
	 */
	String getEntityName();

	/**
	 * Gibt das Kürzel der Entity zurück, Bsp: "bib".
	 * 
	 * @return entityKey
	 */
	String getEntityKey();

	/**
	 * Gibt JPA String zurück. Nach dem "select" steht der Key der übergebenen Entity. 
	 * Sollte Entity nicht im JPA Statement vorkommen, wird der Key der From-Entity ("abc") genommen.
	 * 
	 * @param  select die Entity die selektiert werden soll
	 * @return		  JPA String
	 */
	String get(Select select);

	/**
	 * Setzt das Attribut durch das gefiltert werden soll. Muss ein Attribut der from-/join-Klasse sein.
	 * 
	 * @param attribute
	 * @return
	 */
	ToMany<Input, Output> attribute(String attribute);

	/**
	 * Setzt den operator auf "=" und merkt sich den Wert der verglichen werden soll.
	 * 
	 * @param value
	 * @return
	 */
	ToMany<Input, Output> equals(String value);
	
	/**
	 * Setzt den operator auf "<" und merkt sich den Wert der verglichen werden soll.
	 * 
	 * @param value
	 * @return
	 */
	ToMany<Input, Output> lower(String value);

	/**
	 * Setzt den operator auf ">" und merkt sich den Wert der verglichen werden soll.
	 * 
	 * @param value
	 * @return
	 */
	ToMany<Input, Output> upper(String value);
	
	String getAttribute();
	
	String getOperator();
	
	String getValue();
	
}
