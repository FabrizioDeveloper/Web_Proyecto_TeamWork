package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Oficio;
import pe.edu.upc.service.IOficioService;

@Named
@RequestScoped

public class OficioController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IOficioService mService;
	
	private Oficio oficio;
	List<Oficio> listaOficios;
	
	@PostConstruct
	public void init() {
		this.listaOficios = new ArrayList<Oficio>();
		this.oficio= new Oficio();
		this.listar();
	}
	
	public String nuevoOficio() {
		this.setOficio(new Oficio());
		return "oficio.xhtml";
	}
	
	public void insertar() {
		mService.insertar(oficio);
		limpiarOficio();
		this.listar();
	}
	
	public void listar() {
		listaOficios = mService.listar();
	}
	
	public void limpiarOficio() {
		this.init();
	}
	
	public void eliminar(Oficio oficio) {
		mService.eliminar(oficio.getIdOficio());
		this.listar();
	}

	public Oficio getOficio() {
		return oficio;
	}

	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}

	public List<Oficio> getListaOficios() {
		return listaOficios;
	}

	public void setListaOficios(List<Oficio> listaOficios) {
		this.listaOficios = listaOficios;
	}
	
}
