package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Departamento;
import pe.edu.upc.entity.Provincia;

import pe.edu.upc.service.IDepartamentoService;
import pe.edu.upc.service.IProvinciaService;

@Named
@RequestScoped

public class ProvinciaController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDepartamentoService dService;
	
	@Inject
	private IProvinciaService pService;
	
	private Departamento departamento;
	private Provincia provincia;
	
	List<Departamento> listaDepartamentos;
	List<Provincia> listaProvincias;
	
	@PostConstruct
	public void init() {
		departamento = new Departamento();
		provincia= new Provincia();
		
		listaDepartamentos = new ArrayList<Departamento>();
		listaProvincias= new ArrayList<Provincia>();
		
		this.listDepartamento();
		this.listProvincia();		
	}
	
	public String nuevoProvincia() {
		this.setProvincia(new Provincia());
		return "provincia.xhtml";
	}
	
	public void insertar() {
		pService.insertar(provincia);
		limpiarProvincia();
		this.listProvincia();
	}
	
	public void listDepartamento() {
		listaDepartamentos = dService.listar();
	}
	
	public void listProvincia() {
		listaProvincias = pService.listar();
	}
	
	public void limpiarProvincia() {
		this.init();
	}
	
	public void eliminar(Provincia provincia) {
		pService.eliminar(provincia.getIdProvincia());
		this.listProvincia();
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<Departamento> getListaDepartamentos() {
		return listaDepartamentos;
	}

	public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}

	public List<Provincia> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<Provincia> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}
	
}
