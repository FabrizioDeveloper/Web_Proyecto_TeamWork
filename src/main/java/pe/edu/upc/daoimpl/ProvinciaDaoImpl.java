package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IProvinciaDao;
import pe.edu.upc.entity.Provincia;

public class ProvinciaDaoImpl implements IProvinciaDao, Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="a")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Provincia provincia) {
		em.persist(provincia);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> listar() {
		List<Provincia> lista = new ArrayList<Provincia>();
		Query q = em.createQuery("select p from Provincia p");
		lista = (List<Provincia>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idProvincia) {
		Provincia provincia = new Provincia();
		provincia = em.getReference(Provincia.class, idProvincia);
		em.remove(provincia);
	}
	
}
