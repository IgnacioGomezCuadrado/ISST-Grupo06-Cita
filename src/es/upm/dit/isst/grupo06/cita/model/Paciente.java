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
	
	
	
public Paciente() {
	
}

public int getId() {
	return id;
}

public String getNombre() {
	return nombre;
}

public void setNombrel(String nombre) {
	this.nombre = nombre;
}

public String getApellidos() {
	return apellidos;
}

public void setApellidosl(String apellidos) {
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

public void setTarjetaSanitarial(String tarjetaSanitaria) {
	this.tarjetaSanitaria = tarjetaSanitaria;
}

	
	
	
	
}
