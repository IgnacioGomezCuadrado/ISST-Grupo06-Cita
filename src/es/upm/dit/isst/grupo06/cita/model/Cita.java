package es.upm.dit.isst.grupo06.cita.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private Date fecha;
	private Time hora;
	@ManyToOne
	private Medico medico;
	@ManyToOne
	private Paciente paciente;
	private boolean confirmada;
	private boolean urgencia;
	@ManyToOne
	private Consulta consulta;
	
	public Cita() {
		
	}

	public int getId() {
		return id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	

	

}

