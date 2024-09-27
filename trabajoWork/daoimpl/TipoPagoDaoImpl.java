package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ITipoPagoDao;
import pe.edu.upc.entity.TipoPago;

public class TipoPagoDaoImpl implements ITipoPagoDao, Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="a")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(TipoPago tipoPago) {
		em.persist(tipoPago);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPago> listar() {
		List<TipoPago> lista = new ArrayList<TipoPago>();
		Query q = em.createQuery("select tp from TipoPago tp");
		lista = (List<TipoPago>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idTipoPago) {
		TipoPago tipoPago = new TipoPago();
		tipoPago = em.getReference(TipoPago.class, idTipoPago);
		em.remove(tipoPago);
	}

}
