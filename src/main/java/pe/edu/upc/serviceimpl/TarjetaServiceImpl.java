package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ITarjetaDao;
import pe.edu.upc.entity.Tarjeta;
import pe.edu.upc.service.ITarjetaService;

@Named
@RequestScoped

public class TarjetaServiceImpl implements ITarjetaService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITarjetaDao mD;

	@Override
	public void insertar(Tarjeta tarjeta) {
		mD.insertar(tarjeta);
	}

	@Override
	public List<Tarjeta> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idTarjeta) {
		mD.eliminar(idTarjeta);
	}

}
