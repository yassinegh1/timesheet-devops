package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Concour;
import tn.esprit.spring.repository.ConcourRepository;


@Service
public class ConcourService {
	
	@Autowired
	ConcourRepository concourrepo;
	
	public int ajouterConcour(Concour concour) {
		concourrepo.save(concour);
		return concour.getIdCandidat();
	}
	
	public List<Concour> getAllConcours() {
		return (List<Concour>) concourrepo.findAll();
	}
	
	public int calculertaille () {
		int l=0;
		List<Concour> lista=new ArrayList();
		l= lista.size()+1;
		return l;
		
	} 
	public void deleteConcourById(int idcandidat) {
		Concour contratManagedEntity = concourrepo.findById(idcandidat).get();
		concourrepo.delete(contratManagedEntity);

	}
	public Optional<Concour> getconcourbycandidat(int idcandidat) { 
		return concourrepo.findById(idcandidat);	}
	

}
