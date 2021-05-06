package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Trabajador;

public interface ITrabajadorDao {
	public void insertar(Trabajador trabajador);
	public List<Trabajador> listar();
	public void eliminar(int idTrabajador);
}
