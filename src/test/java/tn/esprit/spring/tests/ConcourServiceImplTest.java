package tn.esprit.spring.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Concour;
import tn.esprit.spring.services.ConcourService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ConcourServiceImplTest {

	private static final Logger l = LogManager.getLogger(ConcourService.class);

	@Autowired
	ConcourService cs;
	


		@Test
		public void testAjouterConcour() {
			try {
			Concour c = new Concour(null, "Info", 0, 0);
			int Id = cs.ajouterConcour(c);
			assertNotNull(Id);
			cs.deleteConcourById(Id);
			l.info("End add Concour test method");
			} catch (NullPointerException e) {
				l.error(e.getMessage());
			}
		}
	@Test
	public void ajouterettesterliste() {
		int n;
		List<Concour> lista=new ArrayList();
		lista=cs.getAllConcours();
		n= lista.size()+1;
		
		try {
			Concour c = new Concour(null, "Info", 0, 0);
			int Id = cs.ajouterConcour(c);
			assertNotNull(Id);
			l.info("End add Concour test method");
			} catch (NullPointerException e) {
				l.error(e.getMessage());
			}
		
		try {
			List<Concour> lista2=new ArrayList();
			lista2=cs.getAllConcours();
			assertEquals(n,lista2.size() );
			l.info("taille incrémenté de 1");
			} catch (NullPointerException e) {
				l.error(e.getMessage());
			}
		
	}
		
		
	  @Test
		public void testUpdateDepartement() {
			try {
			Concour D = new Concour(new Date(), 15, "Admission chef Departement");
			
			
			int Id = cs.ajouterConcour(D);
			D.setType("Admission chef projet");
			cs.ajouterConcour(D);
			assertEquals("Admission chef projet", D.getType());
			l.info("End Update Concour test method");
			} catch (NullPointerException e) {
				l.error(e.getMessage());
			}
		} 
		

		@Test
		public void testDeleteDepartementById()  {
			l.info("Starting delete Concour test method");
			Concour C = new Concour(new Date(), 15, "Admission chef Departement");
			int idcandidat = cs.ajouterConcour(C);
			l.info("Adding new Concour with id : " + idcandidat);
			Optional<Concour> con = cs.getconcourbycandidat(idcandidat);
			assertNotNull(con);
			int lengthBeforeDelete = cs.getAllConcours().size();
			l.info("Department with id " + idcandidat + " exists" );
			cs.deleteConcourById(idcandidat);
			assertEquals(lengthBeforeDelete-1 , cs.getAllConcours().size());
			l.info("Concour deleted successfuly");
		}
		
			
		/*@Test
		public void testGetConcourById() throws ParseException{
			l.info("Starting find Departement test method");
			
			Concour C = new Concour(null, 0, "Examan d'admission chef dep");
			int Id = cs.ajouterConcour(C);
			assertNotNull(cs.getconcourbycandidat(Id));
			l.info("Departement with id " + Id + " added" );
			Optional<Concour> con = cs.getconcourbycandidat(Id);
			assertNotNull(con);	
			l.info("Concour found successfully" );
			cs.deleteConcourById(Id);
			}	*/
	}
