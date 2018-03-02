package org.orders.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Table(name="PEDIDOS")  
@Entity(name="pedido")
public class Pedido {
	@Id
	@Column(name="Idpedido")
	//@GeneratedValue(generator = "pedidos_seq")
	@SequenceGenerator(name="pedidos_seq", sequenceName="pedidos_seq",allocationSize=1)
	private int Idpedido;

	@ManyToOne
	@JoinColumn(name="IdCliente")
	private Cliente cliente;
	/*
	@ManyToOne
	private Empleados empleado;*/

	@Column(name="Fechapedido")
	private Date Fechapedido;

	@Column(name="Fechaentrega")
	private Date Fechaentrega;

	@Column(name="Fechaenvio")
	private Date Fechaenvio;

	@Column(name="Formaenvio")
	private Integer Formaenvio;

	@Column(name="Cargo")
	private Double Cargo;

	@NotBlank(message="Requerido")
	@Column(name="Destinatario")
	private String Destinatario;

	@NotBlank(message="Requerido")
	@Column(name="Direcciondestinatario")
	private String Direcciondestinatario;

	@Column(name="Ciudaddestinatario")
	private String Ciudaddestinatario;

	@Column(name="Regiondestinatario")
	private String Regiondestinatario;

	@Column(name="Codpostaldestinatario")
	private String Codpostaldestinatario;

	@Column(name="Paisdestinatario")
	private String Paisdestinatario;

	@Column(name="Monto")
	private Double Monto;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pedido")
	private Set<Detalle> detalles = new HashSet<Detalle>();

	public int getIdpedido() {
		return Idpedido;
	}

	public void setIdpedido(int idpedido) {
		Idpedido = idpedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechapedido() {
		return Fechapedido;
	}

	public void setFechapedido(Date fechapedido) {
		Fechapedido = fechapedido;
	}

	public Date getFechaentrega() {
		return Fechaentrega;
	}

	public void setFechaentrega(Date fechaentrega) {
		Fechaentrega = fechaentrega;
	}

	public Date getFechaenvio() {
		return Fechaenvio;
	}

	public void setFechaenvio(Date fechaenvio) {
		Fechaenvio = fechaenvio;
	}

	public Integer getFormaenvio() {
		return Formaenvio;
	}

	public void setFormaenvio(Integer formaenvio) {
		Formaenvio = formaenvio;
	}

	public Double getCargo() {
		return Cargo;
	}

	public void setCargo(Double cargo) {
		Cargo = cargo;
	}

	public String getDestinatario() {
		return Destinatario;
	}

	public void setDestinatario(String destinatario) {
		Destinatario = destinatario;
	}

	public String getDirecciondestinatario() {
		return Direcciondestinatario;
	}

	public void setDirecciondestinatario(String direcciondestinatario) {
		Direcciondestinatario = direcciondestinatario;
	}

	public String getCiudaddestinatario() {
		return Ciudaddestinatario;
	}

	public void setCiudaddestinatario(String ciudaddestinatario) {
		Ciudaddestinatario = ciudaddestinatario;
	}

	public String getRegiondestinatario() {
		return Regiondestinatario;
	}

	public void setRegiondestinatario(String regiondestinatario) {
		Regiondestinatario = regiondestinatario;
	}

	public String getCodpostaldestinatario() {
		return Codpostaldestinatario;
	}

	public void setCodpostaldestinatario(String codpostaldestinatario) {
		Codpostaldestinatario = codpostaldestinatario;
	}

	public String getPaisdestinatario() {
		return Paisdestinatario;
	}

	public void setPaisdestinatario(String paisdestinatario) {
		Paisdestinatario = paisdestinatario;
	}

	public Double getMonto() {
		return Monto;
	}

	public void setMonto(Double monto) {
		Monto = monto;
	}

	public Set<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(Set<Detalle> detalles) {
		this.detalles = detalles;
	}
	
	
	
	
}
