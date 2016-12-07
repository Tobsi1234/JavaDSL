package de.dhbw.stuttgart.swe2.javadsl2;

import java.util.ArrayList;
import java.util.List;

public class SimpleManyServiceImpl<Input, Output> implements ManyService<Input, Output> {

	public static <Input, Output> ManyService<Input, Output> from(ToMany<Input, Output> toMany) {
		return new SimpleManyServiceImpl<Input, Output>(toMany);
	}


	private String obj1;
	private List<String> joinObjekte = new ArrayList<>();
	private List<String> joinKeys = new ArrayList<>();

	private ToMany<Input, Output> toMany;

	SimpleManyServiceImpl(ToMany<Input, Output> toMany) {
		this.toMany = toMany;
	}

	@Override
	public String get() {
		return "select abc from " + this.getObj1() + " join " + this.getJoinObjekte().get(0);
	}

	@Override
	public <NextOutput> ManyService<Input, NextOutput> join(ManyService<Output, NextOutput> toMany) {
		return new BridgingManyServiceImpl<Input, Output, NextOutput>(this, toMany);
	}

	@Override
	public <NextOutput> ManyService<Input, NextOutput> join(ToMany<Output, NextOutput> toMany) {
		this.joinObjekte.add(this.joinKeys.get(1) + "." + toMany.getEntityName() + " " + toMany.getEntityKey());
		BridgingManyServiceImpl<Input, Output, NextOutput> bridgingManyServiceImpl = new BridgingManyServiceImpl<Input, Output, NextOutput>(this, toMany);
		this.joinKeys.add(toMany.getEntityKey());
		bridgingManyServiceImpl.setObj1(this.obj1);
		bridgingManyServiceImpl.setJoinObjekte(this.joinObjekte);
		bridgingManyServiceImpl.setJoinKeys(this.joinKeys);
		return bridgingManyServiceImpl;
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
