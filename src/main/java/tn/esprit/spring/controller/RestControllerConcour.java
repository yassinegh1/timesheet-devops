package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Concour;
import tn.esprit.spring.services.ConcourService;

@RestController

public class RestControllerConcour {
	
	@Autowired
	ConcourService concourservice;
	
	@PostMapping("/ajouterConcour")
	@ResponseBody
	public int ajouterContrat(@RequestBody Concour concour) {
		concourservice.ajouterConcour(concour);
		return concour.getIdCandidat();
	}
	
	@DeleteMapping("/deleteConcourById/{idcandidat}") 
	@ResponseBody
	public void deleteContratById(@PathVariable("idcandidat")int idcandidat) {
		concourservice.deleteConcourById(idcandidat);
	}
	@GetMapping(value = "/getAllConcours")
    @ResponseBody
	public List<Concour> getAllEmployes() {
		
		return concourservice.getAllConcours();
	}
	
	@GetMapping("/getConcourById/{idcandidat}")
	public Optional<Concour> getConcourbyid(@PathVariable("idcandidat")int idcandidat) {
	
		return concourservice.getconcourbycandidat(idcandidat);

	}
}
