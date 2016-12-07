package de.dhbw.stuttgart.swe2.javadsl2;

public interface ToOne<Input, Output> extends ToMany<Input, Output>{
	
	Output getOne(Input input);

}
