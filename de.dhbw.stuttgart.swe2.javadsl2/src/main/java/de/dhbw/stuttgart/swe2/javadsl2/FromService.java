package de.dhbw.stuttgart.swe2.javadsl2;

public interface FromService<T> {
	
	<NextOutput> ManyService<T, NextOutput> join(ToMany<T, NextOutput> toMany);

	<NextOutput> FromService<T> filter(ToMany<T, NextOutput> toMany);
}
