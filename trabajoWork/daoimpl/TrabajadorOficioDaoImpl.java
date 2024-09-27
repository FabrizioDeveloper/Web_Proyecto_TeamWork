package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ITrabajadorOficioDao;
import pe.edu.upc.entity.TrabajadorOficio;

public class TrabajadorOficioDaoImpl implements ITrabajadorOficioDao, Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="a")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(TrabajadorOficio trabajadorOficio) {
		em.persist(trabajadorOficio);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrabajadorOficio> listar() {
		List<TrabajadorOficio> lista = new ArrayList<TrabajadorOficio>();
		Query q = em.createQuery("select to from TrabajadorOficio to");
		lista = (List<TrabajadorOficio>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idTrabajadorOficio) {
		TrabajadorOficio trabajadorOficio= new TrabajadorOficio();
		trabajadorOficio= em.getReference(TrabajadorOficio.class, idTrabajadorOficio);
		em.remove(trabajadorOficio);
	}	

}
