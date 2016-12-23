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
	private List<String> filterStmts = new ArrayList<>();

	private ToMany<Input, Output> toMany;

	SimpleManyServiceImpl(ToMany<Input, Output> toMany) {
		this.toMany = toMany;
	}

	@Override
	public String get() {
		return "select abc from " + this.getObj1() + " join " + this.getJoinObjekte().get(0);
	}
	
	@Override
	public String get(Select select) {
		String selectEntityName = select.getEntityName();
		boolean selectExists = false;
		for(String entityName : this.getJoinKeys()) {
			if(entityName.equals(selectEntityName)) {
				selectExists = true;
			}
		}
		if(!selectExists) {
			selectEntityName = "abc"; //either it's the from-Entity or it's not there, anyway...
		}
		return "select " + selectEntityName + " from " + this.getObj1() + " join " + this.getJoinObjekte().get(0);
	}


	@Override
	public <NextOutput> ManyService<Input, NextOutput> join(ToMany<Output, NextOutput> toMany) {
		this.joinObjekte.add(this.joinKeys.get(1) + "." + toMany.getEntityName() + " " + toMany.getEntityKey());
		BridgingManyServiceImpl<Input, Output, NextOutput> bridgingManyServiceImpl = new BridgingManyServiceImpl<Input, Output, NextOutput>(this, toMany);
		this.joinKeys.add(toMany.getEntityKey());
		bridgingManyServiceImpl.setObj1(this.obj1);
		bridgingManyServiceImpl.setJoinObjekte(this.joinObjekte);
		bridgingManyServiceImpl.setJoinKeys(this.joinKeys);
		bridgingManyServiceImpl.setFilterStmts(this.filterStmts);
		return bridgingManyServiceImpl;
	}
	

	@Override
	public <NextOutput> ManyService<Input, NextOutput> filter(ToMany<Output, NextOutput> toMany) {
		String filterStmt = toMany.getEntityKey() + "." + toMany.getAttribute() + " " + toMany.getOperator() + " '" + toMany.getValue() + "'";
		this.filterStmts.add(filterStmt);
		BridgingManyServiceImpl<Input, Output, NextOutput> bridgingManyServiceImpl = new BridgingManyServiceImpl<Input, Output, NextOutput>(this, toMany);
		bridgingManyServiceImpl.setObj1(this.obj1);
		bridgingManyServiceImpl.setJoinObjekte(this.joinObjekte);
		bridgingManyServiceImpl.setJoinKeys(this.joinKeys);
		bridgingManyServiceImpl.setFilterStmts(this.filterStmts);

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
	
	public List<String> getFilterStmts() {
		return filterStmts;
	}

	public void setFilterStmts(List<String> filterStmts) {
		this.filterStmts = filterStmts;
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

	@Override
	public String getAttribute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOperator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToMany<Input, Output> attribute(String attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToMany<Input, Output> equals(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToMany<Input, Output> lower(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToMany<Input, Output> upper(String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
