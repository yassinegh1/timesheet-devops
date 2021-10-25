package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
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
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
		try {
			l.info("In affecterDepartementAEntreprise method");	
				Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
				Departement depManagedEntity = deptRepoistory.findById(depId).get();
				
				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				deptRepoistory.save(depManagedEntity);
				l.info("Out of affecterDepartementAEntreprise method");	

		}
		catch(Exception e){
			l.error("Error in affecterDepartementAEntreprise method", e);
		}
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		List<String> depNames = new ArrayList<>();

		try {
			
			l.info("In getAllDepartementsNamesByEntreprise method");	

		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
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
		entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).get());	
		l.info("Out of deleteEntrepriseById method");

		}
		catch(Exception e){
			l.error("Error in deleteEntrepriseById method", e);
		}
		
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		try {
			l.info("In deleteDepartementById method");
		deptRepoistory.delete(deptRepoistory.findById(depId).get());
		l.info("Out of deleteDepartementById method");
		}
		catch(Exception e){
			l.error("Error in deleteDepartementById method", e);
		}
		
	}


	public Entreprise getEntrepriseById(int entrepriseId) {
		Entreprise x=null ;
		try {
			l.info("In getEntrepriseById method");
		 x=entrepriseRepoistory.findById(entrepriseId).get();
			l.info("Out of getEntrepriseById method");
		}
		catch(Exception e){
			l.error("Error in getEntrepriseById method", e);
		}
		return x;
	}


}
