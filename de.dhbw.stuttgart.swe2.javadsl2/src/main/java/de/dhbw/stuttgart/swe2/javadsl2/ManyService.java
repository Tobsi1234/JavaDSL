package de.dhbw.stuttgart.swe2.javadsl2;

public interface ManyService<Input, Output> extends ToMany<Input, Output> {
	
	<NextOutput> ManyService<Input, NextOutput> join(ToMany<Output, NextOutput> toMany);
	
	<NextOutput> ManyService<Input, NextOutput> filter(ToMany<Output, NextOutput> toMany);
	
}
