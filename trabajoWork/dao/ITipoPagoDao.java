package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.TipoPago;

public interface ITipoPagoDao {
	public void insertar(TipoPago tipoPago);
	public List<TipoPago> listar();
	public void eliminar(int idTipoPago);
}
