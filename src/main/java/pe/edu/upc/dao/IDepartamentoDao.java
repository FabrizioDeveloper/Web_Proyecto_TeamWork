package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Departamento;

public interface IDepartamentoDao {
	public void insertar(Departamento departamento);
	public List<Departamento> listar();
	public void eliminar(int idDepartamento);
}
