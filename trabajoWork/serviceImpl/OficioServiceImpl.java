package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IOficioDao;
import pe.edu.upc.entity.Oficio;
import pe.edu.upc.service.IOficioService;

@Named
@RequestScoped

public class OficioServiceImpl implements IOficioService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IOficioDao mD;

	@Override
	public void insertar(Oficio oficio) {
		mD.insertar(oficio);
	}

	@Override
	public List<Oficio> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idOficio) {
		mD.eliminar(idOficio);
	}

}
