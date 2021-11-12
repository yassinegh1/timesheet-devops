package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);
	
	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	public int ajouterEntreprise(Entreprise entreprise) {
		try {
			l.info("In ajouterEntreprise method");
		
		entrepriseRepoistory.save(entreprise);
		l.info("Out of ajouterEntreprise method");
		}
		catch(Exception e){
			l.error("Error in ajouterEntreprise method", e);
		}
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		try {
			l.info("In ajouterDepartement method");	
			deptRepoistory.save(dep);
			l.info("Out of ajouterDepartement method");
	
		}
		catch(Exception e){
			l.error("Error in ajouterDepartement method", e);
		}
		return dep.getId();
	}
	
		
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		List<String> depNames = new ArrayList<>();

		try {
			
			l.info("In getAllDepartementsNamesByEntreprise method");	

		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElse(new Entreprise());
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
		}
		l.info("Out of getAllDepartementsNamesByEntreprise method");

		}
		catch(Exception e){
			l.error("Error in getAllDepartementsNamesByEntreprise method", e);
		}
		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		try {
			l.info("In deleteEntrepriseById method");	
		entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).orElse(new Entreprise()));	
		l.info("Out of deleteEntrepriseById method");

		}
		catch(Exception e){
			l.error("Error in deleteEntrepriseById method", e);
		}
		
	}

	

	public Entreprise getEntrepriseById(int entrepriseId) {
		Entreprise x=null ;
		try {
			l.info("In getEntrepriseById method");
		 x=entrepriseRepoistory.findById(entrepriseId).orElse(new Entreprise());
			l.info("Out of getEntrepriseById method");
		}
		catch(Exception e){
			l.error("Error in getEntrepriseById method", e);
		}
		return x;
	}


}
