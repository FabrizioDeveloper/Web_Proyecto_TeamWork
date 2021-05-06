package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Distrito;
import pe.edu.upc.entity.Provincia;

import pe.edu.upc.service.IDistritoService;
import pe.edu.upc.service.IProvinciaService;

@Named
@RequestScoped

public class DistritoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProvinciaService pService;
	
	@Inject
	private IDistritoService dService;
	
	private Provincia provincia;
	private Distrito distrito;
	
	List<Provincia> listaProvincias;
	List<Distrito> listaDistritos;
	
	@PostConstruct
	public void init() {
		provincia = new Provincia();
		distrito = new Distrito();
		
		listaProvincias= new ArrayList<Provincia>();
		listaDistritos= new ArrayList<Distrito>();
		
		this.listProvincia();
		this.listDistrito();
	}
	
	public String nuevoDistrito() {
		this.setDistrito(new Distrito());
		return "distrito.xhtml";
	}
	
	public void insertar() {
		dService.insertar(distrito);
		limpiarDistrito();
		this.listDistrito();
	}
	
	public void listProvincia() {
		listaProvincias = pService.listar();
	}
	
	public void listDistrito() {
		listaDistritos = dService.listar();
	}
	
	public void limpiarDistrito() {
		this.init();
	}
	
	public void eliminar(Distrito distrito) {
		dService.eliminar(distrito.getIdDistrito());
		this.listDistrito();
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public List<Provincia> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<Provincia> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	public List<Distrito> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Distrito> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}
	
}
