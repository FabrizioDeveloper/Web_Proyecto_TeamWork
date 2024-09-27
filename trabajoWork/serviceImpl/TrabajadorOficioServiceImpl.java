package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ITrabajadorOficioDao;
import pe.edu.upc.entity.TrabajadorOficio;
import pe.edu.upc.service.ITrabajadorOficioService;

@Named
@RequestScoped

public class TrabajadorOficioServiceImpl implements ITrabajadorOficioService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITrabajadorOficioDao mD;

	@Override
	public void insertar(TrabajadorOficio trabajadorOficio) {
		mD.insertar(trabajadorOficio);
	}

	@Override
	public List<TrabajadorOficio> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idTrabajadorOficio) {
		mD.eliminar(idTrabajadorOficio);
	}

}
