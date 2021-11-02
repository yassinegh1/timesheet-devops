package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Concour implements Serializable {
	
	private static final long serialVersionUID = 6191889143079517027L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcandidat;
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	private String type;
	
	private float note;
	
	


	public Concour() {
		super();
	}
	
	public Concour(Date dateDebut, String type, float note, int idcandidat) {
		this.dateDebut = dateDebut;
		this.type = type;
		this.note = note;
	}


	public Concour(Date date, float note, String type) {
		this.dateDebut = dateDebut;
		this.type = type;
		this.note = note;
		
		// TODO Auto-generated constructor stub
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	

	public String getType() {
		return type;
	}

	public void setType(String typeContrat) {
		this.type = typeContrat;
	}

	public float getNote() {
		return note;
	}

	public void setNote(float salaire) {
		this.note = salaire;
	}

	public int getIdCandidat() {
		return idcandidat;
	}

	public void setIdCandidat(String candidat) {
		this.idcandidat = idcandidat;
	}

	
	
	
}
