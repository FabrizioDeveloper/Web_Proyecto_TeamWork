package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Oficio;

public interface IOficioDao {
	public void insertar(Oficio oficio);
	public List<Oficio> listar();
	public void eliminar(int idOficio);
}
