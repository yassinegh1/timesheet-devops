package tn.esprit.spring.Bus.entities;

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
	
	private LocalTime HeureDepartMatin;
	
	private LocalTime HeureDepartAprès_Midi;
	
	/*@ManyToMany(mappedBy="Bus", cascade = CascadeType.ALL)
	private Set<Employe> employees = new HashSet<>();*/

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
		return HeureDepartMatin;
	}

	/**
	 * @param heureDepartMatin the heureDepartMatin to set
	 */
	public void setHeureDepartMatin(LocalTime heureDepartMatin) {
		HeureDepartMatin = heureDepartMatin;
	}

	/**
	 * @return the heureDepartAprès_Midi
	 */
	public LocalTime getHeureDepartAprès_Midi() {
		return HeureDepartAprès_Midi;
	}

	/**
	 * @param heureDepartAprès_Midi the heureDepartAprès_Midi to set
	 */
	public void setHeureDepartAprès_Midi(LocalTime heureDepartAprès_Midi) {
		HeureDepartAprès_Midi = heureDepartAprès_Midi;
	}

	/**
	 * @return the employees
	 */
	/*public Set<Employe> getEmployees() {
		return employees;
	}*/

	/**
	 * @param employees the employees to set
	 */
	/*public void setEmployees(Set<Employe> employees) {
		this.employees = employees;
	}*/

	/**
	 * @param destination
	 * @param heureDepartMatin
	 * @param heureDepartAprès_Midi
	 */
	public Bus(String dest, LocalTime heureDepartMatin, LocalTime heureDepartAprès_Midi) {
		super();
		destination = dest;
		HeureDepartMatin = heureDepartMatin;
		HeureDepartAprès_Midi = heureDepartAprès_Midi;
	}

	/**
	 * 
	 */
	public Bus() {
		super();
	}	
}
