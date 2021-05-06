package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.SolicitaTrabajador;

public interface ISolicitaTrabajadorService {
	public void insertar(SolicitaTrabajador solicitaTrabajador);
	public List<SolicitaTrabajador> listar();
	public void eliminar(int idSolicitaTrabajador);
}
