package es.upm.dit.isst.grupo06.cita.dao;

import java.util.List;
import es.upm.dit.isst.webLab.model.Paciente;

public interface PacienteDAO {

	
	public void createPaciente(Paciente paciente);
	public void updatePaciente(Paciente paciente);
	public void deletePaciente(Paciente paciente);
	public Paciente readPaciente (String dni);
	public Paciente loginPaciente(String dni, String password);
	public List <Paciente> readAllPaciente();
}
