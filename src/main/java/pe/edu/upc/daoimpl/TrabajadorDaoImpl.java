package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ITrabajadorDao;
import pe.edu.upc.entity.Trabajador;

public class TrabajadorDaoImpl implements ITrabajadorDao, Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="a")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Trabajador trabajador) {
		em.persist(trabajador);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trabajador> listar() {
		List<Trabajador> lista = new ArrayList<Trabajador>();
		Query q = em.createQuery("select t from Trabajador t");
		lista = (List<Trabajador>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idTrabajador) {
		Trabajador trabajador = new Trabajador();
		trabajador = em.getReference(Trabajador.class, idTrabajador);
		em.remove(trabajador);
	}

}
