package es.upm.dit.isst.grupo06.cita.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellidos;
	private String password;
	private String dni;
	
	@Id
	private String email;
	
	private int telefono;
	private String sociedadMedica;
	private String tarjetaSanitaria;
	@OneToMany(mappedBy = "paciente", fetch = FetchType.EAGER)
	private Collection<Cita> citas;

	public Paciente() {

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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getSociedadMedica() {
		return sociedadMedica;
	}

	public void setSociedadMedica(String sociedadMedica) {
		this.sociedadMedica = sociedadMedica;
	}

	public String getTarjetaSanitaria() {
		return tarjetaSanitaria;
	}

	public void setTarjetaSanitaria(String tarjetaSanitaria) {
		this.tarjetaSanitaria = tarjetaSanitaria;
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
	
}
