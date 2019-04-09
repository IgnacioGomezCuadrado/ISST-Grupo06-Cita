package es.upm.dit.isst.grupo06.cita.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int numero;
	private int planta;
	private String departamento;
}
