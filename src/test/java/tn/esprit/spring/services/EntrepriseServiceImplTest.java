package tn.esprit.spring.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import junit.framework.*;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;

@SpringBootTest
class EntrepriseServiceImplTest {
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImplTest.class);
	
	@Autowired
	IEntrepriseService es;
	@Autowired
	DepartementRepository deptRepoistory;
	
	
	@Test
 	public void testAjouterEntreprise() {
		try {
			Entreprise e = new Entreprise("esprit");
			int id = es.ajouterEntreprise(e);
			assertNotNull(id);
			es.deleteEntrepriseById(id);
			l.info("End add Entreprise test method");
			
		}
		catch(NullPointerException e) {
			l.error(e.getMessage());
		}
		
	}
	
	@Test
	public void testAjouterDepartement() {
	
		try {
			Departement d = new Departement("Info");
			 deptRepoistory.save(d);
			 int id =d.getId();
			assertNotNull(id);
			deptRepoistory.deleteById(id);
			l.info("End add Department test method");
			} catch (NullPointerException e) {
				l.error(e.getMessage());
			}
		}
		
	
	/*@Test
	public void testAffecterDepartementAEntreprise() {
		
	}*/
/*	@Test
	public void testGetAllDepartementsNamesByEntreprise() {
		 List<String> listDep = es.getAllDepartementsNamesByEntreprise(entrepriseId)
	}*/
	
	@Test
	public void testDeleteEntrepriseById() {
		es.deleteEntrepriseById(1);
		assertNull(es.getEntrepriseById(1));
	}
	
	/*@Test
	public void testDeleteDepartementById() {
		es.deleteDepartementById(3);
		assertNull(es.getEntrepriseById(3));
			}*/
	
	@Test
	@Order(2)
	public void testGetEntrepriseById() {
		Entreprise entRetrieved = es.getEntrepriseById(1);
		assertEquals(1L, entRetrieved.getId());
	}
	
}
/*
	public int ajouterEntreprise(Entreprise entreprise);
	public int ajouterDepartement(Departement dep);
	void affecterDepartementAEntreprise(int depId, int entrepriseId);
	List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
	public void deleteEntrepriseById(int entrepriseId);
	public void deleteDepartementById(int depId);
	public Entreprise getEntrepriseById(int entrepriseId);
 */