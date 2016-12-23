package de.dhbw.stuttgart.swe2.bibliothek.jpa.test;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import de.dhbw.stuttgart.swe2.bibliothek.Artist;
import de.dhbw.stuttgart.swe2.bibliothek.Ausleihinformation;
import de.dhbw.stuttgart.swe2.bibliothek.Ausleihobjekt;
import de.dhbw.stuttgart.swe2.bibliothek.Ausweis;
import de.dhbw.stuttgart.swe2.bibliothek.Bibliothek;
import de.dhbw.stuttgart.swe2.bibliothek.Cd;
import de.dhbw.stuttgart.swe2.bibliothek.Herausgeber;
import de.dhbw.stuttgart.swe2.bibliothek.Kunde;
import de.dhbw.stuttgart.swe2.bibliothek.Mitarbeiter;
import de.dhbw.stuttgart.swe2.bibliothek.Objektinformation;
import de.dhbw.stuttgart.swe2.bibliothek.Titel;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.AbstractIdentifiable;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.ArtistJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.AusleihinformationJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.AusleihobjektJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.AusweisJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.BibliothekJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.CdJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.HerausgeberJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.KundeJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.MitarbeiterJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.ObjektinformationJPA;
import de.dhbw.stuttgart.swe2.bibliothek.jpa.TitelJPA;

public class PersistenceTest {

	//private static final String PERSISTENCE_UNIT_NAME = "derby-embedded-inmemory";
	//private static final String PERSISTENCE_UNIT_NAME = "derby-network";
	private static final String PERSISTENCE_UNIT_NAME = "derby-bib";

	private static EntityManagerFactory factory;

	final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PersistenceTest.class);

	@org.junit.BeforeClass
	public static void setup() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	@Test
	public void testBib() throws ParseException {
		// Objekte erstellen
		MitarbeiterJPA ma = new MitarbeiterJPA();
		List<Mitarbeiter> mas = new ArrayList<>();

		Ausleihinformation ausleihInfo = new AusleihinformationJPA();
		List<Ausleihinformation> ausleihInfos = new ArrayList<>();
		
		Kunde kunde = new KundeJPA();
		
		Ausweis ausweis = new AusweisJPA();
		
		Bibliothek bib = new BibliothekJPA();
		List<Bibliothek> bibs = new ArrayList<>();
		
		AusleihobjektJPA ausleihObj = new AusleihobjektJPA();
		List<Ausleihobjekt> ausleihObjs = new ArrayList<>();
		
		Objektinformation objInfo = new ObjektinformationJPA();
		List<Objektinformation> objInfos = new ArrayList<>();
		
		Herausgeber herausgeber = new HerausgeberJPA();
		List<Herausgeber> herausgebers = new ArrayList<>();
		
		Cd cd = new CdJPA();
		List<Cd> cds = new ArrayList<>();
		
		Titel titel = new TitelJPA();
		List<Titel> titels = new ArrayList<>();
		
		Artist artist = new ArtistJPA();
		List<Artist> artists = new ArrayList<>();
		
		// Objekte befüllen
		ausleihInfos.add(ausleihInfo);
		ausleihObjs.add(ausleihObj);
		bibs.add(bib);
		mas.add(ma);

		ma.setName("Max");
		ma.setBibliothek(bib);
		ma.setAusleihinfos(ausleihInfos);
		
		kunde.setAusweis(ausweis);
		kunde.setAusleihinfos(ausleihInfos);
	
		bib.setName("Stadtbibliothek");
		bib.setMitarbeiter(mas);		
		bib.setAusleihobjekte(ausleihObjs);
		
		ausleihObj.setBibliotheken(bibs);
		ausleihObj.setAusleihinfos(ausleihInfos);
		ausleihObj.setObjektinformation(objInfo);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date ausleihdatum = df.parse("2016-01-01 12:00:00.123");

		ausleihInfo.setAusleihdatum(ausleihdatum);
		ausleihInfo.setAusleihobjekt(ausleihObj);
		ausleihInfo.setKunde(kunde);
		ausleihInfo.setMitarbeiter(ma);
		
		objInfo.setAusleihobjekte(ausleihObjs);
		objInfo.setHerausgeber(herausgebers);
		
		herausgeber.setObjektinfos(objInfos);
		
		cd.setTitel(titels);
		titel.setCds(cds);
		titel.setArtists(artists);
		artist.setTitel(titels);
		
		// Objekte speichern
		EntityManager entityManager = factory.createEntityManager();
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			try {
				entityManager.persist(ausleihObj);
				transaction.commit();
			} finally {
				if (transaction.isActive())
					transaction.rollback();
			}
			AbstractIdentifiable reloaded = entityManager.find(AusleihobjektJPA.class, ausleihObj.getId());
			assertEquals(ausleihObj, reloaded);
		} finally {
			entityManager.close();
		}
	}

}
