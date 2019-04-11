package es.upm.dit.isst.grupo06.cita.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HorarioConsulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@ManyToOne
	private Medico medico;
	private int diaSemana;
	private Time horaComienzoM;
	private Time horaFinM;
	private Time horaComienzoT;
	private Time horaFinT;

	public HorarioConsulta() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Time getHoraComienzoM() {
		return horaComienzoM;
	}

	public void setHoraComienzoM(Time horaComienzoM) {
		this.horaComienzoM = horaComienzoM;
	}

	public Time getHoraFinM() {
		return horaFinM;
	}

	public void setHoraFinM(Time horaFinM) {
		this.horaFinM = horaFinM;
	}

	public Time getHoraComienzoT() {
		return horaComienzoT;
	}

	public void setHoraComienzoT(Time horaComienzoT) {
		this.horaComienzoT = horaComienzoT;
	}

	public Time getHoraFinT() {
		return horaFinT;
	}

	public void setHoraFinT(Time horaFinT) {
		this.horaFinT = horaFinT;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
