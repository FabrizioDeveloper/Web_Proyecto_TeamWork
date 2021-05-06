package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Provincia;

public interface IProvinciaDao {
	public void insertar(Provincia provincia);
	public List<Provincia> listar();
	public void eliminar(int idProvincia);
}
