package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.Trabajador;

import pe.edu.upc.service.IUsuarioService;
import pe.edu.upc.service.ITrabajadorService;

@Named
@RequestScoped

public class TrabajadorController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITrabajadorService tService;
	
	@Inject
	private IUsuarioService uService;
	
	private Trabajador trabajador;
	private Usuario usuario;
	
	List<Trabajador> listaTrabajadores;
	List<Usuario> listaUsuarios;
	
	@PostConstruct
	public void init() {
		trabajador = new Trabajador();
		usuario = new Usuario();
		
		listaTrabajadores = new ArrayList<Trabajador>();
		listaUsuarios = new ArrayList<Usuario>();
		
		this.listTrabajador();
		this.listUsuario();
	}
	
	public String nuevoTrabajador() {
		this.setTrabajador(new Trabajador());
		return "trabajador.xhtml";
	}
	
	public void insertar() {
		tService.insertar(trabajador);
		limpiarTrabajador();
		this.listTrabajador();
	}
	
	public void listTrabajador() {
		listaTrabajadores = tService.listar();
	}
	
	public void listUsuario() {
		listaUsuarios = uService.listar();
	}
	
	public void limpiarTrabajador() {
		this.init();
	}
	
	public void eliminar(Trabajador trabajador) {
		tService.eliminar(trabajador.getIdTrabajador());
		this.listTrabajador();
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Trabajador> getListaTrabajadores() {
		return listaTrabajadores;
	}

	public void setListaTrabajadores(List<Trabajador> listaTrabajadores) {
		this.listaTrabajadores = listaTrabajadores;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
}
