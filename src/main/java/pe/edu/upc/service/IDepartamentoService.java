package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Departamento;

public interface IDepartamentoService {
	public void insertar(Departamento departamento);
	public List<Departamento> listar();
	public void eliminar(int idDepartamento);
}
