package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IDepartamentoDao;
import pe.edu.upc.entity.Departamento;

public class DepartamentoDaoImpl implements IDepartamentoDao, Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="a")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Departamento departamento) {
		em.persist(departamento);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> listar() {
		List<Departamento> lista = new ArrayList<Departamento>();
		Query q = em.createQuery("select d from Departamento d");
		lista = (List<Departamento>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idDepartamento) {
		Departamento departamento = new Departamento();
		departamento = em.getReference(Departamento.class, idDepartamento);
		em.remove(departamento);
	}	

}
