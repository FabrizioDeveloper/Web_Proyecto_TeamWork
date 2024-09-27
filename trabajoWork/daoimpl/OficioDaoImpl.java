package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IOficioDao;
import pe.edu.upc.entity.Oficio;

public class OficioDaoImpl implements IOficioDao, Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="a")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Oficio oficio) {
		em.persist(oficio);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Oficio> listar() {
		List<Oficio> lista = new ArrayList<Oficio>();
		Query q = em.createQuery("select o from Oficio o");
		lista = (List<Oficio>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idOficio) {
		Oficio oficio = new Oficio();
		oficio = em.getReference(Oficio.class, idOficio);
		em.remove(oficio);
	}
	
}
