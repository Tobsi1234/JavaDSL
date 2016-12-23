package de.dhbw.stuttgart.swe2.javadsl2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;


public class FromServiceImpl<T> implements FromService<T> {
	
	
	private String obj1;
	private List<String> joinObjekte = new ArrayList<>();
	private List<String> joinKeys = new ArrayList<>();
	private List<String> filterStmts = new ArrayList<>();

	
	public static <T> FromService<T> from() {
		return new FromServiceImpl<T>();
	}

	public static <T> FromService<T> from(Class<T> c) {
		String obj1 = c.getAnnotation(Entity.class).name();
		//System.out.println(obj1);
		FromServiceImpl<T> fromService = new FromServiceImpl<T>();
		fromService.obj1 = obj1 + " abc";
		fromService.joinKeys.add("abc");
		return fromService;
	}
	
	@Override
	public <NextOutput> ManyService<T, NextOutput> join(ToMany<T, NextOutput> toMany) {
		//String joinObj = toMany.toString().split("To")[1].split("@")[0];
		//String joinObj = "abc." + toMany.get();
		//String obj1 = this.obj1;
		//System.out.println(obj1 + joinObj);
		this.joinObjekte.add(this.joinKeys.get(0) + "." + toMany.getEntityName() + " " + toMany.getEntityKey()); //"abc." nur beim ersten join!
		SimpleManyServiceImpl<T, NextOutput> simpleManyServiceImpl = new SimpleManyServiceImpl<T, NextOutput>(toMany);
		this.joinKeys.add(toMany.getEntityKey());
		simpleManyServiceImpl.setObj1(this.obj1);
		simpleManyServiceImpl.setJoinObjekte(this.joinObjekte);
		simpleManyServiceImpl.setJoinKeys(this.joinKeys);
		simpleManyServiceImpl.setFilterStmts(this.filterStmts);
		return simpleManyServiceImpl;
	}
	
	@Override
	public <NextOutput> FromService<T> filter(ToMany<T, NextOutput> toMany) {
		String filterStmt = "abc." + toMany.getAttribute() + " " + toMany.getOperator() + " '" + toMany.getValue() + "'";
		this.filterStmts.add(filterStmt);
		FromServiceImpl<T> fromService = new FromServiceImpl<T>();
		fromService.obj1 = this.obj1;
		fromService.joinKeys = this.joinKeys;
		fromService.filterStmts = this.filterStmts;
		return fromService;
	}

	
	@Override
	public <NextOutput> ManyService<T, NextOutput> join(ManyService<T, NextOutput> manyService) {
		return new SimpleManyServiceImpl<T, NextOutput>(manyService);
	}

	@Override
	public <NextOutput> OneService<T, NextOutput> join(ToOne<T, NextOutput> toOne) {
		return new SimpleOneServiceImpl<T, NextOutput>(toOne);
	}

	@Override
	public <NextOutput> OneService<T, NextOutput> join(OneService<T, NextOutput> toOne) {
		return new SimpleOneServiceImpl<T, NextOutput>(toOne);
	}
}
