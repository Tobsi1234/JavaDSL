package de.dhbw.stuttgart.swe2.javadsl2.bibliothek;

//import static de.dhbw.stuttgart.swe2.javadsl2.bibliothek.Dsl.from;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.dhbw.stuttgart.swe2.bibliothek.Bibliothek;
import de.dhbw.stuttgart.swe2.bibliothek.Mitarbeiter;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.AbstractIdentifiable;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.AusleihinformationJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.AusleihobjektJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.BibliothekJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.MitarbeiterJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.ObjektinformationJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.test.PersistenceTest;
import de.dhbw.stuttgart.swe2.javadsl2.Select;
import de.dhbw.stuttgart.swe2.javadsl2.ToMany;

import static de.dhbw.stuttgart.swe2.javadsl2.FromServiceImpl.from;



/*
from(Bibliothek.class).join(ausleihobjekte).join(ausleihinfos).filter(...).select(Bibliothek.class).get();

"Select bib from Bibliothek bib join bib.ausleihobjekte ao join ao.ausleihinfos where ... "


from(BibliothekJPA.class).join(ausleihobjekte()).filter(name.equals(Obj)).join(ausleihinfos()).join(mitarbeiter()).filter(name.equals(Max)).select(Mitarbeiter).get();

"select mi from BIBLIOTHEK abc join abc.ausleihobjekte ao join ao.ausleihinfos ai join ai.mitarbeiter mi where mi.name = 'Max' AND ao.name = 'Obj";

*/


public class DslTest {

	//private static final String PERSISTENCE_UNIT_NAME = "derby-embedded-inmemory";
	//private static final String PERSISTENCE_UNIT_NAME = "derby-network";
	private static final String PERSISTENCE_UNIT_NAME = "derby-bib";

	private static EntityManagerFactory factory;

	final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PersistenceTest.class);
	
	// Bibliothek zu Ausleihobjekt
	private static final BibliothekToAusleihobjekt BIBLIOTHEK_TO_AUSLEIHOBJEKT = new BibliothekToAusleihobjekt();

	private static ToMany<BibliothekJPA, AusleihobjektJPA> ausleihobjekte() {
		return BIBLIOTHEK_TO_AUSLEIHOBJEKT;
	}

	private static class BibliothekToAusleihobjekt implements ToMany<BibliothekJPA, AusleihobjektJPA> {

		@Override
		public String get() {
			return "";
		}
		
		@Override
		public String getEntityName() {
			return "ausleihobjekte";
		}
		
		@Override
		public String getEntityKey() {
			return "ao";
		}

		@Override
		public String get(de.dhbw.stuttgart.swe2.javadsl2.Select select) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	//Ausleihobjekt zu Ausleihinfo
	private static final AusleihobjektToAusleihinformation AUSLEIHOBJEKT_TO_AUSLEIHINFORMATION = new AusleihobjektToAusleihinformation();

	private static ToMany<AusleihobjektJPA, AusleihinformationJPA> ausleihinfos() {
		return AUSLEIHOBJEKT_TO_AUSLEIHINFORMATION;
	}

	private static class AusleihobjektToAusleihinformation implements ToMany<AusleihobjektJPA, AusleihinformationJPA> {

		@Override
		public String get() {
			return "";
		}
		
		@Override
		public String getEntityName() {
			return "ausleihinfos";
		}
		
		@Override
		public String getEntityKey() {
			return "ai";
		}

		@Override
		public String get(de.dhbw.stuttgart.swe2.javadsl2.Select select) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	//Ausleihobjekt zu Ausleihinfo
	private static final AusleihobjektToObjektinformation AUSLEIHOBJEKT_TO_OBJEKTINFORMATION = new AusleihobjektToObjektinformation();

	private static ToMany<AusleihobjektJPA, ObjektinformationJPA> objektinfo() {
		return AUSLEIHOBJEKT_TO_OBJEKTINFORMATION;
	}

	private static class AusleihobjektToObjektinformation implements ToMany<AusleihobjektJPA, ObjektinformationJPA> {

		@Override
		public String get() {
			return "";
		}
		
		@Override
		public String getEntityName() {
			return "objektinfo";
		}
		
		@Override
		public String getEntityKey() {
			return "oi";
		}

		@Override
		public String get(de.dhbw.stuttgart.swe2.javadsl2.Select select) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	//Ausleihinfo zu Mitarbeiter
	private static final AusleihinformationToMitarbeiter AUSLEIHINFORMATION_TO_MITARBEITER = new AusleihinformationToMitarbeiter();

	private static ToMany<AusleihinformationJPA, MitarbeiterJPA> mitarbeiter() {
		return AUSLEIHINFORMATION_TO_MITARBEITER;
	}

	private static class AusleihinformationToMitarbeiter implements ToMany<AusleihinformationJPA, MitarbeiterJPA> {

		@Override
		public String get() {
			return "";
		}
		
		@Override
		public String getEntityName() {
			return "mitarbeiter";
		}
		
		@Override
		public String getEntityKey() {
			return "mi";
		}

		@Override
		public String get(de.dhbw.stuttgart.swe2.javadsl2.Select select) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	
	@BeforeClass
	public static void setup() {
		//factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	/*
	@Before
	public void persistBib() {
		BibliothekJPA bib = new BibliothekJPA();
		bib.setName("Stadtbibliothek");
		MitarbeiterJPA ma = new MitarbeiterJPA();
		ma.setName("max");
		List<Mitarbeiter> mitarbeiter = new ArrayList<>();
		mitarbeiter.add(ma);
		bib.setMitarbeiter(mitarbeiter);
		
		EntityManager entityManager = factory.createEntityManager();
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			try {
				entityManager.persist(bib);
				transaction.commit();
			} finally {
				if (transaction.isActive())
					transaction.rollback();
			}
			AbstractIdentifiable reloaded = entityManager.find(BibliothekJPA.class, bib.getId());
			assertEquals(bib.getName(), "Stadtbibliothek");
		} finally {
			entityManager.close();
		}
	}
	*/

	@Test
	public void test() {
		//String jpaStmt = from(BibliothekJPA.class).join(ausleihobjekte()).join(ausleihinfos()).join(mitarbeiter()).get(Select.BIBLIOTHEK);
		//String jpaStmt2 = from(BibliothekJPA.class).join(ausleihobjekte()).join(objektinfo()).get();
		String jpaStmt = from(BibliothekJPA.class).join(ausleihobjekte()).get(Select.AUSLEIHOBJEKT);

		// JPA Statement testen
		/*
		EntityManager entityManager = factory.createEntityManager();
		try {
			TypedQuery<Bibliothek> query = entityManager.createQuery(jpaStmt, Bibliothek.class);
			//query.setParameter("name", "Max");
			String result = "";

			if(!query.getResultList().isEmpty()) {
				//int element = query.getResultList().size() - 1;
				result = query.getResultList().get(0).getName();
				//System.out.println(result);
			}

			assertEquals("Stadtbibliothek", result);
		} finally {
			entityManager.close();
		}
		*/
		System.out.println(jpaStmt);
	}
}
