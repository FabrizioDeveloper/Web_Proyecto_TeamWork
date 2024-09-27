package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Trabajador;
import pe.edu.upc.entity.Oficio;
import pe.edu.upc.entity.TrabajadorOficio;

import pe.edu.upc.service.ITrabajadorService;
import pe.edu.upc.service.IOficioService;
import pe.edu.upc.service.ITrabajadorOficioService;

@Named
@RequestScoped

public class TrabajadorOficioController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITrabajadorService tService;
	
	@Inject
	private IOficioService oService;
	
	@Inject
	private ITrabajadorOficioService toService;
	
	private Trabajador trabajador;
	private Oficio oficio;
	private TrabajadorOficio trabajadorOficio;
	
	List<Trabajador> listaTrabajadores;
	List<Oficio> listaOficios;
	List<TrabajadorOficio> listaTrabajadorOficios;
	
	@PostConstruct
	public void init() {
		trabajador = new Trabajador();
		oficio = new Oficio();
		trabajadorOficio = new TrabajadorOficio();
		
		listaTrabajadores = new ArrayList<Trabajador>();
		listaOficios = new ArrayList<Oficio>();
		listaTrabajadorOficios = new ArrayList<TrabajadorOficio>();
		
		this.listTrabajador();
		this.listOficio();
		this.listTrabajadorOficio();
	}
	
	public String nuevoTrabajadorOficio() {
		this.setTrabajadorOficio(new TrabajadorOficio());
		return "trabajadorOficio.xhtml";
	}
	
	public void insertar() {
		toService.insertar(trabajadorOficio);
		limpiarTrabajadorOficio();
		this.listTrabajadorOficio();
	}
	
	public void listTrabajador() {
		listaTrabajadores = tService.listar();
	}
	
	public void listOficio() {
		listaOficios = oService.listar();
	}
	
	public void listTrabajadorOficio() {
		listaTrabajadorOficios = toService.listar();
	}
	
	public void limpiarTrabajadorOficio() {
		this.init();
	}
	
	public void eliminar(TrabajadorOficio trabajadorOficio) {
		toService.eliminar(trabajadorOficio.getIdTrabajadorOficio());
		this.listTrabajadorOficio();
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Oficio getOficio() {
		return oficio;
	}

	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}

	public TrabajadorOficio getTrabajadorOficio() {
		return trabajadorOficio;
	}

	public void setTrabajadorOficio(TrabajadorOficio trabajadorOficio) {
		this.trabajadorOficio = trabajadorOficio;
	}

	public List<Trabajador> getListaTrabajadores() {
		return listaTrabajadores;
	}

	public void setListaTrabajadores(List<Trabajador> listaTrabajadores) {
		this.listaTrabajadores = listaTrabajadores;
	}

	public List<Oficio> getListaOficios() {
		return listaOficios;
	}

	public void setListaOficios(List<Oficio> listaOficios) {
		this.listaOficios = listaOficios;
	}

	public List<TrabajadorOficio> getListaTrabajadorOficios() {
		return listaTrabajadorOficios;
	}

	public void setListaTrabajadorOficios(List<TrabajadorOficio> listaTrabajadorOficios) {
		this.listaTrabajadorOficios = listaTrabajadorOficios;
	}
	
}
