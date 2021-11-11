package tn.esprit.spring.entities;

import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Bus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String destination;
	
	private LocalTime heureDepartMatin;
	
	private LocalTime heureDepartApresMidi;
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String dest) {
		destination = dest;
	}

	

	/**
	 * @return the heureDepartMatin
	 */
	public LocalTime getHeureDepartMatin() {
		return heureDepartMatin;
	}

	/**
	 * @param heureDepartMatin the heureDepartMatin to set
	 */
	public void setHeureDepartMatin(LocalTime heureDepartMatin) {
		this.heureDepartMatin = heureDepartMatin;
	}

	/**
	 * @return the heureDepartApresMidi
	 */
	public LocalTime getHeureDepartApresMidi() {
		return heureDepartApresMidi;
	}

	/**
	 * @param heureDepartApresMidi the heureDepartApresMidi to set
	 */
	public void setHeureDepartApresMidi(LocalTime heureDepartApresMidi) {
		this.heureDepartApresMidi = heureDepartApresMidi;
	}

	
	/**
	 * 
	 */
	public Bus() {
		super();
	}

	/**
	 * @param destination
	 * @param heureDepartMatin
	 * @param heureDepartApresMidi
	 */
	public Bus(String destination, LocalTime heureDepartMatin, LocalTime heureDepartApresMidi) {
		super();
		this.destination = destination;
		this.heureDepartMatin = heureDepartMatin;
		this.heureDepartApresMidi = heureDepartApresMidi;
	}
	
	
}
