package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ITrabajadorDao;
import pe.edu.upc.entity.Trabajador;
import pe.edu.upc.service.ITrabajadorService;

@Named
@RequestScoped

public class TrabajadorServiceImpl implements ITrabajadorService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITrabajadorDao mD;

	@Override
	public void insertar(Trabajador trabajador) {
		mD.insertar(trabajador);
	}

	@Override
	public List<Trabajador> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idTrabajador) {
		mD.eliminar(idTrabajador);
	}

}
