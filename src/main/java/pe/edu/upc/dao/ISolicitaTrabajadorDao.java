package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.SolicitaTrabajador;

public interface ISolicitaTrabajadorDao {
	public void insertar(SolicitaTrabajador solicitaTrabajador);
	public List<SolicitaTrabajador> listar();
	public void eliminar(int idSolicitaTrabajador);
}
