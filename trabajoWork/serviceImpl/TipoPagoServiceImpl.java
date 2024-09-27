package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ITipoPagoDao;
import pe.edu.upc.entity.TipoPago;
import pe.edu.upc.service.ITipoPagoService;

@Named
@RequestScoped

public class TipoPagoServiceImpl implements ITipoPagoService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITipoPagoDao mD;

	@Override
	public void insertar(TipoPago tipoPago) {
		mD.insertar(tipoPago);
	}

	@Override
	public List<TipoPago> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idTipoPago) {
		mD.eliminar(idTipoPago);
	}

}
