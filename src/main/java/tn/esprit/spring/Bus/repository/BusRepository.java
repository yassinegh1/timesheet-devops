package tn.esprit.spring.Bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Bus.entities.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {
	public Bus findById(Long busId);
	public Bus findByDestination(String destination);
}
