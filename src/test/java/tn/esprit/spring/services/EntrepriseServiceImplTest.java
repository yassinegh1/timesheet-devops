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
import tn.esprit.spring.repository.EntrepriseRepository;

@SpringBootTest
public class EntrepriseServiceImplTest {
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImplTest.class);
	
	@Autowired
	IEntrepriseService es;
	@Autowired
	EntrepriseRepository er;
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
	
/*	@Test
	public void testDeleteEntrepriseById() {
		l.info("Starting delete Entreprise test method");
		Entreprise e = new Entreprise("test");
		int id = es.ajouterEntreprise(e);
		Entreprise ent = es.getEntrepriseById(id);
		assertNotNull(ent);
		//int lengthBeforeDelete = ((Object) er.findAll()).size();
		es.deleteDepartementById(id);
		
		
	//	es.deleteEntrepriseById(1);
		//assertNull(es.getEntrepriseById(1));
	}*/
	
	/*@Test
	public void testDeleteDepartementById() {
		es.deleteDepartementById(3);
		assertNull(es.getEntrepriseById(3));
			}*/
	/*
	@Test
	public void testGetEntrepriseById() {
	l.info("Starting find Entreprise test method");
	Entreprise e = new Entreprise("test get entreprise");
	int id = es.ajouterEntreprise(e);
	assertNotNull(es.getEntrepriseById(id));
	l.info("Entreprise with id " + id + " added" );
	Entreprise ent = es.getEntrepriseById(id);
	assertNotNull(ent);	
	l.info("Entreprise with id " + ent.getId() + " found successfully" );
	es.deleteEntrepriseById(id);
		}
	*/
}
/*00000
	public int ajouterEntreprise(Entreprise entreprise);
	public int ajouterDepartement(Departement dep);
	void affecterDepartementAEntreprise(int depId, int entrepriseId);
	List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
	public void deleteEntrepriseById(int entrepriseId);
	public void deleteDepartementById(int depId);
	public Entreprise getEntrepriseById(int entrepriseId);
 00000 */