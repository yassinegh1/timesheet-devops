package tn.esprit.spring.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import junit.framework.*;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

@SpringBootTest
class EntrepriseServiceImplTest {
	@Autowired
	IEntrepriseService es;
	
	/*@Test
 	public void ajouterEntreprise() {
		
	}
	@Test
	public void testAjouterDepartement() {
		
	}
	@Test
	public void testAffecterDepartementAEntreprise() {
		
	}*/
/*	@Test
	public void testGetAllDepartementsNamesByEntreprise() {
		 List<String> listDep = es.getAllDepartementsNamesByEntreprise(entrepriseId)
	}*/
	
	@Test
	@Order(1)
	public void testDeleteEntrepriseById() {
		es.deleteEntrepriseById(1);
		assertNull(es.getEntrepriseById(1));
	}
	
	/*@Test
	public void testDeleteDepartementById() {
		es.deleteDepartementById(3);
		assertNull(es.getEntrepriseById(3));
			}*/
	
	/*@Test
	@Order(2)
	public void testGetEntrepriseById() {
		Entreprise entRetrieved = es.getEntrepriseById(1);
		assertEquals(1L, entRetrieved.getId());
	}*/
	
}
/*
 	public int ajouterEntreprise(Entreprise entreprise);
	public int testAjouterDepartement(Departement dep);
	void testAffecterDepartementAEntreprise(int depId, int entrepriseId);
	List<String> testGetAllDepartementsNamesByEntreprise(int entrepriseId);
	public void testDeleteEntrepriseById(int entrepriseId);
	public void testDeleteDepartementById(int depId);
	public Entreprise testGetEntrepriseById(int entrepriseId);
 */