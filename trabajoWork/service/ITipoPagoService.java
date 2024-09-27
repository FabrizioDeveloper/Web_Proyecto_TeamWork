package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.TipoPago;

public interface ITipoPagoService {
	public void insertar(TipoPago tipoPago);
	public List<TipoPago> listar();
	public void eliminar(int idTipoPago);
}
