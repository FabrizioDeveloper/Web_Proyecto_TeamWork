package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Oficio;

public interface IOficioService {
	public void insertar(Oficio oficio);
	public List<Oficio> listar();
	public void eliminar(int idOficio);
}
