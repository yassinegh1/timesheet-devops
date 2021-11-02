package tn.esprit.spring.Bus.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Bus.entities.Bus;
import tn.esprit.spring.Bus.repository.BusRepository;


@Service
public class BusServiceImpl implements IBusService {
	/*@Autowired
	private EntrepriseRepository entrepriserepository;*/
	
	@Autowired
	private BusRepository busrepository;
	
	/*@Autowired
	private EmployeRepository employerepository;*/
	
/*..........................................................................
  Partie: Ajout d'un nouveau bus
 .........................................................................*/
    
	@Override
	public Bus ajouterBus(Bus bus){
		return busrepository.save(bus);
	}
	
	/*@Override
	public String createBusEntreprise(Bus bus, int EntrpriseId) {
		busrepository.save(bus);
		
		Entreprise existingEntreprise = entrepriserepository.findById(EntrpriseId).orElse(null);
		existingEntreprise.getBus().add(bus);
		entrepriserepository.save(existingEntreprise);
		
		return ("The bus was created and assigned to the entreprise successfully.");

	}*/


	/*@Override
	public String affecterUserABus(Long BusId, int EmployeId) {
		Employe existingEmploye = employerepository.findById(EmployeId).orElse(null);
		Bus existingBus = busrepository.findById(BusId).orElse(null);
		existingEmploye.getBus().add(existingBus);
		employerepository.save(existingEmploye);
		return ("Affectation Done Successfuly.");
	}*/

	
/*.......................................................................................
  Partie: Affichage d'une Liste de Bus(d'un utilisateur ou une entreprise)
 ......................................................................................*/
   	
	public Bus GetBusByID(Long BusId){
		return busrepository.findById(BusId).orElse(null);
	}

	public List<Bus> getAllBus() {
		return busrepository.findAll();
	}

	@Override
	public Bus getBusByDestination(String destination) {
		return busrepository.findByDestination(destination);
	}

	/*@Override
	public Set<Bus> afficherBusEmploye(int employeId) {
		Employe existingEmploye = employerepository.findById(employeId).orElse(null);
		
		Set<Bus> ListeBusEmploye = new HashSet<>();
		if (existingEmploye.getBus() == null){
			return null;
		}else {
			for (Bus B: existingEmploye.getBus()){
				Bus bus = new Bus();
				bus.setId(B.getId());
				bus.setDestination(B.getDestination());
				bus.setHeureDepartMatin(B.getHeureDepartMatin());
				bus.setHeureDepartAprès_Midi(B.getHeureDepartAprès_Midi());
				bus.setEmployees(null);
				
				ListeBusEmploye.add(bus);
			} 
			return ListeBusEmploye;
		}	
	}*/

	/*@Override
	public Set<Bus> afficherBusEntreprise(int EID) {
		Entreprise existingEntreprise = entrepriserepository.findById(EID).orElse(null);
		
		Set<Bus> ListeBusEntreprise = new HashSet<>();
		if (existingEntreprise.getBus() == null){
			return null;
		}else {
			for (Bus B: existingEntreprise.getBus()){
				Bus bus = new Bus();
				bus.setId(B.getId());
				bus.setDestination(B.getDestination());
				bus.setHeureDepartMatin(B.getHeureDepartMatin());
				bus.setHeureDepartAprès_Midi(B.getHeureDepartAprès_Midi());
				bus.setEmployees(null);
				
				ListeBusEntreprise.add(bus);
			} 
			return ListeBusEntreprise;
		}	
	}*/

	
/*..........................................................................
  Partie: Update d'un Bus
 .........................................................................*/
  
	@Override
	public Bus updateBus(Bus bus){
		Bus existingBus = busrepository.findById(bus.getId()).orElse(null);
		existingBus.setDestination(bus.getDestination());
		existingBus.setHeureDepartMatin(bus.getHeureDepartMatin());
		existingBus.setHeureDepartAprès_Midi(bus.getHeureDepartAprès_Midi());
		return busrepository.save(existingBus);
	}
		
		
/*.......................................................
  Partie: Suppression d'un Bus
.......................................................*/		
	
	/*@Override
	public String DésaffecterEmployeBus (int employeId, Long BusId){
		Employe existingEmploye = employerepository.findById(employeId).orElse(null);
		
		Bus existingBus = busrepository.findById(BusId).orElse(null);
		
		if (existingEmploye.getBus().contains(existingBus)){
			existingEmploye.getBus().remove(existingBus);
			employerepository.save(existingEmploye);
			return ("Mr/Mme "+ existingEmploye.getNom() + " " + existingEmploye.getPrenom() + " a été retiré de la liste des voyageurs de ce Bus.");			
		}else{
			return ("Mr/Mme "+ existingEmploye.getNom() + " " + existingEmploye.getPrenom() + " n'est pas un voyageur de ce bus");
		}
	}*/

	
	@Override
	public String DeleteBus (Long BusId){
		Bus existingBus = busrepository.findById(BusId).orElse(null);
		busrepository.delete(existingBus);
		return ("Bus deleted Successfully.");
	}
	
	/*@Override
	public String SupprimerBus(Long BusId, int EntrepriseId) {
		Bus existingBus = busrepository.findById(BusId).orElse(null);
		
		List<Employe> employees = (List<Employe>) employerepository.findAll();
		
		Entreprise existingEntreprise = entrepriserepository.findById(EntrepriseId).orElse(null);
		
		String Response = new String();
		if (existingEntreprise.getBus().contains(existingBus)){
			existingEntreprise.getBus().remove(existingBus);
			Response = Response.concat("Le Bus a été retiré de la liste des Bus de l'entreprise. ");
			busrepository.delete(existingBus);
			Response = Response.concat("Le bus avec l'ID: "+ BusId + " a été supprimé définitivement de notre Base des données.");
		}else{
			return("L'entreprise ne dispose pas de Bus avec cet ID. ");
		}

		for (Employe E:employees){
			if (E.getBus().contains(existingBus)){
				E.getBus().remove(existingBus);
				Response = Response.concat("Le Bus a été retiré de La liste des Bus de Mr/Mme " + E.getNom() + " " + E.getPrenom());
			}
		}	
		return Response;
	}*/
}
