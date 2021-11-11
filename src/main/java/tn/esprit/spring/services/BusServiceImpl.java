package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Bus;
import tn.esprit.spring.repository.BusRepository;


@Service
public class BusServiceImpl implements IBusService {
	
	@Autowired
	private BusRepository busrepository;
	
    
	@Override
	public Bus ajouterBus(Bus bus){
		return busrepository.save(bus);
	}
	
	

	
/*.......................................................................................
  Partie: Affichage d'une Liste de Bus(d'un utilisateur ou une entreprise)
 ......................................................................................*/
   	
	public Bus getBusByID(Long idbus){
		return busrepository.findById(idbus);
	}

	public List<Bus> getAllBus() {
		return busrepository.findAll();
	}

	@Override
	public Bus getBusByDestination(String destination) {
		return busrepository.findByDestination(destination);
	}


	
	
/*..........................................................................
  Partie: Update d'un Bus
 .........................................................................*/
  
	@Override
	public Bus updateBus(Bus bus){
		try{
			Bus existingBus = busrepository.findById(bus.getId());
			existingBus.setDestination(bus.getDestination());
			existingBus.setHeureDepartMatin(bus.getHeureDepartMatin());
			existingBus.setHeureDepartApresMidi(bus.getHeureDepartApresMidi());
			return busrepository.save(existingBus);

		}catch (Exception e) {
			return null;
			}
	}
		
		
/*.......................................................
  Partie: Suppression d'un Bus
.......................................................*/		
	
	@Override
	public String deleteBus (Long idbus){
		Bus existingBus = busrepository.findById(idbus);
		busrepository.delete(existingBus);
		return ("Bus deleted Successfully.");
	}
	
}
