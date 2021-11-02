package tn.esprit.spring.Bus.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Bus.entities.Bus;
import tn.esprit.spring.Bus.services.BusServiceImpl;


@RestController
public class BusController {
	
	@Autowired
	private BusServiceImpl busService;

	
/*===================
  Partie: Post
  =================*/
	
	@PostMapping("/addBus")
	public Bus addBus(@RequestBody Bus bus){
		return busService.ajouterBus(bus);
	}
		
		
	/*@PostMapping ("/createBusEntreprise/{EntrpriseId}")
	public String createBusEntreprise(@RequestBody Bus bus, @PathVariable int EntrpriseId){
		return busService.createBusEntreprise(bus, EntrpriseId);
	}*/

	
/*===================
  Partie: Get
  =================*/	
	
	@GetMapping("/afficherBusByDestination/{destination}")
	public Bus afficherBusByDestination(@PathVariable String destination){
		return busService.getBusByDestination(destination);
	}
	
	/*@GetMapping ("/afficherBusUser/{userId}")
	public Set<Bus> afficherBusUser(@PathVariable int userId){
		return busService.afficherBusEmploye(userId);
	}*/
	
	/*@GetMapping ("/afficherBusEntreprise/{EID}")
	public Set<Bus> afficherBusEntreprise(@PathVariable int EID){
		return busService.afficherBusEntreprise(EID);
	}*/
	
	
/*===================
  Partie: Update
  =================*/

	@PutMapping ("/updateBus")
	public Bus updateBus(@RequestBody Bus bus){
		return busService.updateBus(bus);		
	}
	
	/*@PutMapping ("/affecterEmployeBus/{BusId}/{EmployeID}")
	public String affecterEmployeBus(@PathVariable Long BusId, @PathVariable int EmployeID){
		return busService.affecterUserABus(BusId, EmployeID);
	}*/

	
/*===================
  Partie: delete
  =================*/
	
	@DeleteMapping("/deleteBusByID/{BusID}")
	public String deleteBusById(@PathVariable Long BusID){
		return busService.DeleteBus(BusID);
	}
	
	/*@DeleteMapping("désaffecterEmployeBus/{employeId}/{BusId}")
	public String désaffecterEmployeBus(@PathVariable  int employeId, @PathVariable Long BusId){
		return busService.DésaffecterEmployeBus(employeId, BusId);
	}*/
	
	
	/*@DeleteMapping("/deleteBus/{BusReference}/{EntrepriseId}")
    public String deleteContrat(@PathVariable Long BusReference,@PathVariable int EntrepriseId) {
        return busService.SupprimerBus(BusReference, EntrepriseId);
    }*/
}
