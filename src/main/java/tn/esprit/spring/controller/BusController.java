package tn.esprit.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Bus;
import tn.esprit.spring.services.BusServiceImpl;


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
		
		
/*===================
  Partie: Get
  =================*/	
	
	@GetMapping("/afficherBusByDestination/{destination}")
	public Bus afficherBusByDestination(@PathVariable String destination){
		return busService.getBusByDestination(destination);
	}
	
	
	
/*===================
  Partie: Update
  =================*/

	@PutMapping ("/updateBus")
	public Bus updateBus(@RequestBody Bus bus){
		return busService.updateBus(bus);		
	}
	
/*===================
  Partie: delete
  =================*/
	
	@DeleteMapping("/deleteBusByID/{BusID}")
	public String deleteBusById(@PathVariable Long idbus){
		return busService.deleteBus(idbus);
	}
	
}
