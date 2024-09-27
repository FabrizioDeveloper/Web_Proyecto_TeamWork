package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.TipoPago;
import pe.edu.upc.service.ITipoPagoService;

@Named
@RequestScoped

public class TipoPagoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITipoPagoService mService;
	
	private TipoPago tipoPago;
	List<TipoPago> listaTipoPagos;
	
	@PostConstruct
	public void init() {
		this.listaTipoPagos = new ArrayList<TipoPago>();
		this.tipoPago= new TipoPago();
		this.listar();
	}
	
	public String nuevoTipoPago() {
		this.setTipoPago(new TipoPago());
		return "tipoPago.xhtml";
	}
	
	public void insertar() {
		mService.insertar(tipoPago);
		limpiarTipoPago();
		this.listar();
	}
	
	public void listar() {
		listaTipoPagos = mService.listar();
	}
	
	public void limpiarTipoPago() {
		this.init();
	}
	
	public void eliminar(TipoPago tipoPago) {
		mService.eliminar(tipoPago.getIdTipoPago());
		this.listar();
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public List<TipoPago> getListaTipoPagos() {
		return listaTipoPagos;
	}

	public void setListaTipoPagos(List<TipoPago> listaTipoPagos) {
		this.listaTipoPagos = listaTipoPagos;
	}
	
}
