package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tarjeta")
public class Tarjeta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idTarjeta;
	
	@Column(name="numberTarjeta", nullable=false, length=20)
	private String numeroTarjeta;
	
	@Column(name="DigitosSeguridad", nullable=false, length=3)
	private int seguridadTarjeta;
	
	private Date expiracionTarjeta;

	public Tarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarjeta(int idTarjeta, String numeroTarjeta, int seguridadTarjeta, Date expiracionTarjeta) {
		super();
		this.idTarjeta = idTarjeta;
		this.numeroTarjeta = numeroTarjeta;
		this.seguridadTarjeta = seguridadTarjeta;
		this.expiracionTarjeta = expiracionTarjeta;
	}

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getSeguridadTarjeta() {
		return seguridadTarjeta;
	}

	public void setSeguridadTarjeta(int seguridadTarjeta) {
		this.seguridadTarjeta = seguridadTarjeta;
	}

	public Date getExpiracionTarjeta() {
		return expiracionTarjeta;
	}

	public void setExpiracionTarjeta(Date expiracionTarjeta) {
		this.expiracionTarjeta = expiracionTarjeta;
	}		
	
}
