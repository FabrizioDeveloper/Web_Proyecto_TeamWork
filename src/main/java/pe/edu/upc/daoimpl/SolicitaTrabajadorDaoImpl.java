package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ISolicitaTrabajadorDao;
import pe.edu.upc.entity.SolicitaTrabajador;

public class SolicitaTrabajadorDaoImpl implements ISolicitaTrabajadorDao, Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="a")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(SolicitaTrabajador solicitaTrabajador) {
		em.persist(solicitaTrabajador);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SolicitaTrabajador> listar() {
		List<SolicitaTrabajador> lista = new ArrayList<SolicitaTrabajador>();
		Query q = em.createQuery("select st from SolicitaTrabajador st");
		lista = (List<SolicitaTrabajador>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idSolicitaTrabajador) {
		SolicitaTrabajador solicitaTrabajador= new SolicitaTrabajador();
		solicitaTrabajador= em.getReference(SolicitaTrabajador.class, idSolicitaTrabajador);
		em.remove(solicitaTrabajador);
	}	

}
