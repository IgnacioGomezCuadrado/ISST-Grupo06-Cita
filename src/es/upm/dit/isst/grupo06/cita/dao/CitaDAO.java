package es.upm.dit.isst.grupo06.cita.dao;

import java.util.Date;
import java.util.Collection;

import es.upm.dit.isst.grupo06.cita.model.Cita;
import es.upm.dit.isst.grupo06.cita.model.Consulta;
import es.upm.dit.isst.grupo06.cita.model.Medico;
import es.upm.dit.isst.grupo06.cita.model.Paciente;
import es.upm.dit.isst.grupo06.cita.model.Especialidad;

public interface CitaDAO {
	
	public void create(Cita cita);

	public Cita read(int id);

	public void update(Cita cita);

	public void delete(Cita cita);

	public Collection<Cita> readAll();
	
	public Collection<Cita> getCitasDelDia(Medico medico, Date fecha);
	
	//public Collection<Cita> getCitasFormulario(Paciente paciente, Medico medico, Especialidad especialidad, Date fecha, Consulta consulta);
	
	public Collection<Cita> getCitasFormulario(Paciente paciente, Medico medico, Date fecha, Consulta consulta);
}
