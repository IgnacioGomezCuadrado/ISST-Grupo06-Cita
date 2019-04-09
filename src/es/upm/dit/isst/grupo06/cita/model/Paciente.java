package es.upm.dit.isst.grupo06.cita.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String nombre;
	private String apellidos;
	private String dni;
	private String email;
	private int telefono;
	private String sociedadMedica;
	private String tarjetaSanitaria;
	
}
