package es.upm.dit.isst.grupo06.cita.dao;


import es.upm.dit.isst.grupo06.cita.model.PAS;



public interface PASDAO {
	
	public void create(PAS pas);

	public PAS read(String email);

	public void update(PAS pas);

	public void delete(PAS pas);
	
	public void deleteAll();


}
