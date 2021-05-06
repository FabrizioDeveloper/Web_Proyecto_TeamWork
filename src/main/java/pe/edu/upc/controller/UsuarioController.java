package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Distrito;
import pe.edu.upc.entity.Usuario;

import pe.edu.upc.service.IDistritoService;
import pe.edu.upc.service.IUsuarioService;

@Named
@RequestScoped

public class UsuarioController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDistritoService dService;
	
	@Inject
	private IUsuarioService uService;
	
	private Distrito distrito;
	private Usuario usuario;
	
	List<Distrito> listaDistritos;
	List<Usuario> listaUsuarios;
	
	@PostConstruct
	public void init() {
		distrito = new Distrito();
		usuario= new Usuario();
		
		listaDistritos = new ArrayList<Distrito>();
		listaUsuarios = new ArrayList<Usuario>();
		
		this.listDistrito();
		this.listUsuario();
	}
	
	public String nuevoUsuario() {
		this.setUsuario(new Usuario());
		return "usuario.xhtml";
	}
	
	public void insertar() {
		uService.insertar(usuario);
		limpiarUsuario();
		this.listUsuario();
	}
	
	public void listDistrito() {
		listaDistritos = dService.listar();
	}
	
	public void listUsuario() {
		listaUsuarios = uService.listar();
	}
	
	public void limpiarUsuario() {
		this.init();
	}
	
	public void eliminar(Usuario usuario) {
		uService.eliminar(usuario.getIdUsuario());
		this.listUsuario();
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Distrito> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Distrito> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
}
