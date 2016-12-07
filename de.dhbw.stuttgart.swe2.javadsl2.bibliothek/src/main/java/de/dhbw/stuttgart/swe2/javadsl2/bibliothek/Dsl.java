package de.dhbw.stuttgart.swe2.javadsl2.bibliothek;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;


public class Dsl {
	
	private Object obj1 = new Object();
	private List<Object> joinObjekte = new ArrayList<>();
	
	public static Dsl from(Object obj) {
		Dsl dsl = new Dsl();
		dsl.obj1 = obj;
		return dsl;
	}
	
	public Dsl join(Object obj) {
		this.joinObjekte.add(obj);
		return this;
	}
	
	public void get() {
		String output = "SELECT * FROM " + this.obj1.getClass().getAnnotation(Entity.class).name();
		for(Object obj : this.joinObjekte) {
			output += " JOIN " + obj.getClass().getAnnotation(Entity.class).name();
		}
		System.out.println(output);
	}
}
