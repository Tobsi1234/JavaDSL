package de.dhbw.stuttgart.swe2.javadsl2;

import java.util.ArrayList;
import java.util.List;

public class BridgingManyServiceImpl<Input, Bridged, Output> implements ManyService<Input, Output> {

	private String obj1;
	private List<String> joinObjekte = new ArrayList<>();
	private List<String> joinKeys = new ArrayList<>();
	
	private ManyService<Input, Bridged> first;
	private ManyService<Bridged, Output> second;

	public BridgingManyServiceImpl(ManyService<Input, Bridged> first, ManyService<Bridged, Output> second) {
		this.first = first;
		this.second = second;
	}

	public BridgingManyServiceImpl(ManyService<Input, Bridged> first, ToMany<Bridged, Output> second) {
		this.first = first;
		this.second = new SimpleManyServiceImpl<Bridged, Output>(second);
	}

	@Override
	public <NextOutput> ManyService<Input, NextOutput> join(ManyService<Output, NextOutput> toMany) {
		return new BridgingManyServiceImpl<Input, Output, NextOutput>(this, toMany);
	}

	@Override
	public <NextOutput> ManyService<Input, NextOutput> join(ToMany<Output, NextOutput> toMany) {
		this.joinObjekte.add(this.joinKeys.get(joinKeys.size() -1) + "." + toMany.getEntityName() + " " + toMany.getEntityKey()); 
		BridgingManyServiceImpl<Input, Output, NextOutput> bridgingManyServiceImpl = new BridgingManyServiceImpl<Input, Output, NextOutput>(this, toMany);
		bridgingManyServiceImpl.setObj1(this.obj1);
		bridgingManyServiceImpl.setJoinObjekte(this.joinObjekte);
		bridgingManyServiceImpl.setJoinKeys(this.joinKeys);
		return bridgingManyServiceImpl;
	}

	@Override
	public String get() {
		String output = "select abc from " + this.getObj1();
		for(String objekt : getJoinObjekte()) {
			output += " join " + objekt;
		}
		//return "select abc from " + this.getObj1() + " join " + this.getJoinObjekte().get(0);
		return output;
	}

	public String getObj1() {
		return obj1;
	}

	public void setObj1(String obj1) {
		this.obj1 = obj1;
	}

	public List<String> getJoinObjekte() {
		return joinObjekte;
	}

	public void setJoinObjekte(List<String> joinObjekte) {
		this.joinObjekte = joinObjekte;
	}

	public List<String> getJoinKeys() {
		return joinKeys;
	}

	public void setJoinKeys(List<String> joinKeys) {
		this.joinKeys = joinKeys;
	}

	@Override
	public String getEntityName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityKey() {
		// TODO Auto-generated method stub
		return null;
	}

}