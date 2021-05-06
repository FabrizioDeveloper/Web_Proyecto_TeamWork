package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Trabajador;
import pe.edu.upc.entity.Cliente;
import pe.edu.upc.entity.TipoPago;
import pe.edu.upc.entity.SolicitaTrabajador;

import pe.edu.upc.service.ITrabajadorService;
import pe.edu.upc.service.IClienteService;
import pe.edu.upc.service.ITipoPagoService;
import pe.edu.upc.service.ISolicitaTrabajadorService;

@Named
@RequestScoped

public class SolicitaTrabajadorController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITrabajadorService tService;
	
	@Inject
	private IClienteService cService;
	
	@Inject
	private ITipoPagoService tpService;
	
	@Inject
	private ISolicitaTrabajadorService stService;
	
	private Trabajador trabajador;
	private Cliente cliente;
	private TipoPago tipoPago;
	private SolicitaTrabajador solicitaTrabajador;
	
	List<Trabajador> listaTrabajadores;
	List<Cliente> listaClientes;
	List<TipoPago> listaTipoPagos;
	List<SolicitaTrabajador> listaSolicitaTrabajadores;
	
	@PostConstruct
	public void init() {
		trabajador = new Trabajador();
		cliente = new Cliente();
		tipoPago = new TipoPago();
		solicitaTrabajador = new SolicitaTrabajador();
		
		listaTrabajadores = new ArrayList<Trabajador>();
		listaClientes = new ArrayList<Cliente>();
		listaTipoPagos = new ArrayList<TipoPago>();
		listaSolicitaTrabajadores = new ArrayList<SolicitaTrabajador>();
		
		this.listTrabajador();
		this.listCliente();
		this.listTipoPago();
		this.listSolicitaTrabajador();
	}
	
	public String nuevoSolicitaTrabajador() {
		this.setSolicitaTrabajador(new SolicitaTrabajador());
		return "solicitaTrabajador.xhtml";
	}
	
	public void insertar() {
		stService.insertar(solicitaTrabajador);
		limpiarSolicitaTrabajador();
		this.listSolicitaTrabajador();
	}
	
	public void listTrabajador() {
		listaTrabajadores = tService.listar();
	}
	
	public void listCliente() {
		listaClientes = cService.listar();
	}
	
	public void listTipoPago() {
		listaTipoPagos = tpService.listar();
	}
	
	public void listSolicitaTrabajador() {
		listaSolicitaTrabajadores = stService.listar();
	}
	
	public void limpiarSolicitaTrabajador() {
		this.init();
	}
	
	public void eliminar(SolicitaTrabajador solicitaTrabajador) {
		stService.eliminar(solicitaTrabajador.getIdSolicitaTrabajador());
		this.listSolicitaTrabajador();
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public SolicitaTrabajador getSolicitaTrabajador() {
		return solicitaTrabajador;
	}

	public void setSolicitaTrabajador(SolicitaTrabajador solicitaTrabajador) {
		this.solicitaTrabajador = solicitaTrabajador;
	}

	public List<Trabajador> getListaTrabajadores() {
		return listaTrabajadores;
	}

	public void setListaTrabajadores(List<Trabajador> listaTrabajadores) {
		this.listaTrabajadores = listaTrabajadores;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<TipoPago> getListaTipoPagos() {
		return listaTipoPagos;
	}

	public void setListaTipoPagos(List<TipoPago> listaTipoPagos) {
		this.listaTipoPagos = listaTipoPagos;
	}

	public List<SolicitaTrabajador> getListaSolicitaTrabajadores() {
		return listaSolicitaTrabajadores;
	}

	public void setListaSolicitaTrabajadores(List<SolicitaTrabajador> listaSolicitaTrabajadores) {
		this.listaSolicitaTrabajadores = listaSolicitaTrabajadores;
	}
	
}
