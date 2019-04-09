package es.upm.dit.isst.grupo06.cita.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HorarioConsulta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// TODO: Atributos horario de consulta
	@Id
	private int id;
	@OneToMany
	private Medico medico;
	private String diaSemana;
	private Time horaComienzoM;
	private Time horaFinM;
	private Time horaComienzoT;
	private Time horaFinT;
}
