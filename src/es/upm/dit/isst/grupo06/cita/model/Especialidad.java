package es.upm.dit.isst.grupo06.cita.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Especialidad implements Serializable {

	@Id
	private String nombre;

	public Especialidad() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
