package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IDepartamentoDao;
import pe.edu.upc.entity.Departamento;
import pe.edu.upc.service.IDepartamentoService;

@Named
@RequestScoped

public class DepartamentoServiceImpl implements IDepartamentoService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDepartamentoDao mD;

	@Override
	public void insertar(Departamento departamento) {
		mD.insertar(departamento);
	}

	@Override
	public List<Departamento> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idDepartamento) {
		mD.eliminar(idDepartamento);
	}

}
