package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IProvinciaDao;
import pe.edu.upc.entity.Provincia;
import pe.edu.upc.service.IProvinciaService;

@Named
@RequestScoped

public class ProvinciaServiceImpl implements IProvinciaService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProvinciaDao mD;

	@Override
	public void insertar(Provincia provincia) {
		mD.insertar(provincia);
	}

	@Override
	public List<Provincia> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idProvincia) {
		mD.eliminar(idProvincia);
	}

}
