package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IUsuarioDao;
import pe.edu.upc.entity.Usuario;

public class UsuarioDaoImpl implements IUsuarioDao, Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="a")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Usuario usuario) {
		em.persist(usuario);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<Usuario>();
		Query q = em.createQuery("select u from Usuario u");
		lista = (List<Usuario>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idUsuario) {
		Usuario usuario = new Usuario();
		usuario = em.getReference(Usuario.class, idUsuario);
		em.remove(usuario);
	}

}
