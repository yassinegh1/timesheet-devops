package tn.esprit.spring.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.ArrayList;
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
		int x;
		List<Concour> lista=new ArrayList();
		lista=cs.getAllConcours();
		x= lista.size()+1;
		
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
			assertEquals(x,lista2.size() );
			l.info("taille incrémenté de 1");
			} catch (NullPointerException e) {
				l.error(e.getMessage());
			}
		
	}
		
		
		 /*@Test
		public void testUpdateDepartement() {
			try {
			Departement D = new Departement("Info");
			int Id = ds.ajouterDepartement(D);
			D.setName("Biologie");
			ds.ajouterDepartement(D);
			assertEquals("Biologie", D.getName());
			l.info("End Update Department test method");
			} catch (NullPointerException e) {
				l.error(e.getMessage());
			}
		} */
		

		/*@Test
		public void testDeleteDepartementById()  {
			l.info("Starting delete Department test method");
			Departement D = new Departement("Info");
			int Id = ds.ajouterDepartement(D);
			l.info("Adding new Department with id : " + Id);
			Departement Dept = ds.getDepartementById(Id);
			assertNotNull(Dept);
			int lengthBeforeDelete = ds.getAllDepartements().size();
			l.info("Department with id " + Id + " exists" );
			ds.deleteDepartementById(Id);
			assertEquals(lengthBeforeDelete-1 , ds.getAllDepartements().size());
			l.info("Department deleted successfuly");
		}
		
			
		@Test
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
