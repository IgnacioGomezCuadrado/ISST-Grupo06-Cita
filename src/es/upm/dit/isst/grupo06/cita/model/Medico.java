package es.upm.dit.isst.grupo06.cita.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellidos;
	private String password;
	
	@ManyToOne
	private Especialidad especialidad;
	
	@Id
	private String email;
	
	@OneToMany(mappedBy = "medico", fetch = FetchType.LAZY)
	private Collection<HorarioConsulta> horarioConsulta;
	
	@OneToMany(mappedBy = "medico", fetch = FetchType.EAGER)
	private Collection<Cita> citas;

	public Medico() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<HorarioConsulta> getHorarioConsulta() {
		return horarioConsulta;
	}

	public void setHorarioConsulta(Collection<HorarioConsulta> horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}

	public Collection<Cita> getCitas() {
		return citas;
	}

	public void setCitas(Collection<Cita> citas) {
		this.citas = citas;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
