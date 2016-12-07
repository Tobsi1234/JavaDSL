package de.dhbw.stuttgart.swe2.javadsl2.bibliothek;

//import static de.dhbw.stuttgart.swe2.javadsl2.bibliothek.Dsl.from;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.dhbw.stuttgart.swe2.bibliothek.Bibliothek;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.AbstractIdentifiable;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.AusleihinformationJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.AusleihobjektJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.BibliothekJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.MitarbeiterJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.test.PersistenceTest;
import de.dhbw.stuttgart.swe2.javadsl2.ToMany;

import static de.dhbw.stuttgart.swe2.javadsl2.FromServiceImpl.from;



/*
from(Bibliothek.class).join(ausleihobjekte).join(ausleihinfos).filter(...).select(Bibliothek.class).get();

"Select bib from Bibliothek bib join bib.ausleihobjekte ao join ao.ausleihinfos where ... "
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
	}
	
	//Ausleihobjekt zu Ausleihinfo
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
		String jpaStmt = from(BibliothekJPA.class).join(ausleihobjekte()).join(ausleihinfos()).join(mitarbeiter()).get();
		
		// JPA Statement testen
		/*
		EntityManager entityManager = factory.createEntityManager();
		try {
			TypedQuery<Bibliothek> query = entityManager.createQuery(jpaStmt, Bibliothek.class);
			String result = "";

			if(!query.getResultList().isEmpty()) {
				int element = query.getResultList().size() - 1;
				result = query.getResultList().get(element).getName();
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
