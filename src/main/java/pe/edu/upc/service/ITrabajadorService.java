package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Trabajador;

public interface ITrabajadorService {
	public void insertar(Trabajador trabajador);
	public List<Trabajador> listar();
	public void eliminar(int idTrabajador);
}
