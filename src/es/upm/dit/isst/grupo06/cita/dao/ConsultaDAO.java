package es.upm.dit.isst.grupo06.cita.dao;

import java.util.Collection;

import es.upm.dit.isst.grupo06.cita.model.Consulta;


public interface ConsultaDAO {
	
	public void create(Consulta consulta);

	public Consulta read(int numero);

	public void update(Consulta consulta);

	public void delete(Consulta consulta);

	public Collection<Consulta> readAll();
	
}
