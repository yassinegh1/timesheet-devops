package tn.esprit.spring.services;

import tn.esprit.spring.entities.Bus;

public interface IBusService {

	public Bus ajouterBus(Bus bus);


	public Bus getBusByDestination(String destination);

	public Bus updateBus(Bus bus);

	
	public String deleteBus(Long busId);

	
}
