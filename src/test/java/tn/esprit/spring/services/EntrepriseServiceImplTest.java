package tn.esprit.spring.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.annotation.Order;

import javassist.NotFoundException;
import junit.framework.*;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

public class EntrepriseServiceImplTest {
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImplTest.class);
	
	@Autowired
	IEntrepriseService es;
	@Autowired
	EntrepriseRepository er;
	@Autowired
	DepartementRepository deptRepoistory;
	

	
	
 	public void testAjouterEntreprise() {
		try {
			Entreprise e = new Entreprise(1, "esprit");
			int id = es.ajouterEntreprise(e);
			assertNotNull(id);
			es.deleteEntrepriseById(id);
			l.info("End add Entreprise test method");
			
		}
		catch(NullPointerException e) {
			l.error("erreur d'ajout entreprise"+e.getMessage());
		}
		
	}
	
	
	public void testAjouterDepartement() {
	
		try {
			Departement d = new Departement("Info");
			 deptRepoistory.save(d);
			 int id =d.getId();
			assertNotNull(id);
			deptRepoistory.deleteById(id);
			l.info("End add Department test method");
			} catch (NullPointerException e) {
				l.error("erreur d'ajout departement "+e.getMessage());
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
	
	
	public void testGetEntrepriseById() {
		try {

		Entreprise getEntreprise = es.getEntrepriseById(1);
		assertEquals(2L, getEntreprise.getId());
		l.info("End get Entreprise test method");
			}
		 catch (NullPointerException e) {
				l.error("error get entreprise "+e.getMessage());
			}
		}
	
}
