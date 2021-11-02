package tn.esprit.spring.Bus.services;

import tn.esprit.spring.Bus.entities.Bus;

public interface IBusService {

	public Bus ajouterBus(Bus bus);

	//public String createBusEntreprise(Bus bus, int EntrpriseId);

	//public String affecterUserABus(Long BusId, int EmployeId);

	public Bus getBusByDestination(String destination);

	public Bus updateBus(Bus bus);

	//public Set<Bus> afficherBusEmploye(int employeId);

	//public Set<Bus> afficherBusEntreprise(int EID);

	public String DeleteBus(Long BusId);

	//public String SupprimerBus(Long BusId, int EntrepriseId);
	
	//public String DésaffecterEmployeBus (int employeId, Long BusId);

}
