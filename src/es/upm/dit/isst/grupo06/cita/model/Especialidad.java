package es.upm.dit.isst.grupo06.cita.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Especialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;
	@OneToMany(mappedBy = "especialidad", fetch = FetchType.EAGER)
	private Collection<Medico> medicosEsp;

	public Especialidad() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Medico> getMedicosEsp() {
		return medicosEsp;
	}

	public void setMedicosEsp(Collection<Medico> medicosEsp) {
		this.medicosEsp = medicosEsp;
	}

}
