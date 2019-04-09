package es.upm.dit.isst.grupo06.cita.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	private int id;
	private String nombre;
	private String apellidos;
	private String especialidad;
	private String email;
	//TODO Mirar lo de mappedby
	@OneToMany
	private Collection<HorarioConsulta> horarioConsulta;
	
}
