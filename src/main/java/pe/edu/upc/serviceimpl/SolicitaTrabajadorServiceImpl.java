package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ISolicitaTrabajadorDao;
import pe.edu.upc.entity.SolicitaTrabajador;
import pe.edu.upc.service.ISolicitaTrabajadorService;

@Named
@RequestScoped

public class SolicitaTrabajadorServiceImpl implements ISolicitaTrabajadorService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ISolicitaTrabajadorDao mD;

	@Override
	public void insertar(SolicitaTrabajador solicitaTrabajador) {
		mD.insertar(solicitaTrabajador);
	}

	@Override
	public List<SolicitaTrabajador> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idSolicitaTrabajador) {
		mD.eliminar(idSolicitaTrabajador);
	}

}
