package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Provincia;

public interface IProvinciaService {
	public void insertar(Provincia provincia);
	public List<Provincia> listar();
	public void eliminar(int idProvincia);
}
