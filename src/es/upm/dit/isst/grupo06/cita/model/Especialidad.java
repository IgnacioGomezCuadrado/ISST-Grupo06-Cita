package es.upm.dit.isst.grupo06.cita.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Especialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // Auto incremento
	private int id; //Dejar en null cuando vayas a crear una especialidad
	
	private String nombre;
	
	@OneToMany(mappedBy = "especialidad", fetch = FetchType.EAGER)
	private Set<Medico> medicosEsp;

	public Especialidad() {

	}
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Medico> getMedicosEsp() {
		return medicosEsp;
	}

	public void setMedicosEsp(Set<Medico> medicosEsp) {
		this.medicosEsp = medicosEsp;
	}

}
