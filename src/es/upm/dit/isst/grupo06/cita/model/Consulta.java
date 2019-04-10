package es.upm.dit.isst.grupo06.cita.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int numero;
	private int planta;
	private String departamento;
	@OneToMany(mappedBy = "consulta", fetch = FetchType.EAGER)
	private Collection<Cita> citas;

	public Consulta() {

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Collection<Cita> getCitas() {
		return citas;
	}

	public void setCitas(Collection<Cita> citas) {
		this.citas = citas;
	}

}
