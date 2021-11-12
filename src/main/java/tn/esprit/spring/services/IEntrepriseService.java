package tn.esprit.spring.services;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
@Service
public interface IEntrepriseService {
	
	public int ajouterEntreprise(Entreprise entreprise);
	public int ajouterDepartement(Departement dep);
	public void deleteEntrepriseById(int entrepriseId);
	public Entreprise getEntrepriseById(int entrepriseId);

	
}
