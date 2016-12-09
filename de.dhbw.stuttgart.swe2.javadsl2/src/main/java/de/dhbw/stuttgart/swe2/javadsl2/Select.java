package de.dhbw.stuttgart.swe2.javadsl2;

public enum Select {
    BIBLIOTHEK ("bib"), AUSLEIHOBJEKT ("ao"), AUSLEIHINFORMATION ("ai"), MITARBEITER ("mi"), OBJEKTINFORMATION ("oi");
	
	private final String entityName;
	Select (String entityName) {
		this.entityName = entityName;
	}
	
	public String getEntityName() {
		return entityName;
	}
}
