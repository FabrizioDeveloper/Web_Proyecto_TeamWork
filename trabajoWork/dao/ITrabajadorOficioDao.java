package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.TrabajadorOficio;

public interface ITrabajadorOficioDao {
	public void insertar(TrabajadorOficio trabajadorOficio);
	public List<TrabajadorOficio> listar();
	public void eliminar(int idTrabajadorOficio);
}
