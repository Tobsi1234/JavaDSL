package de.dhbw.stuttgart.swe2.javadsl2.bibliothek;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;


public class Dsl2 {
	
	private static Object obj1 = new Object();
	private static List<Object> joinObjekte = new ArrayList<>();
	
	public Dsl2(Object obj) {
		// TODO Auto-generated constructor stub
	}

	public Dsl2() {
		// TODO Auto-generated constructor stub
	}

	public static Dsl2 from(Object obj) {
		return new Dsl2(obj);
	}
	
	public Dsl2 join(Object obj) {
		joinObjekte.add(obj);
		return new Dsl2();
	}
	
	public void get() {
		String output = "SELECT * FROM " + obj1.getClass().getAnnotation(Entity.class).name();
		for(Object obj : joinObjekte) {
			output += " JOIN " + obj.getClass().getAnnotation(Entity.class).name();
		}
		joinObjekte.clear();
		System.out.println(output);
	}
	
	
}
