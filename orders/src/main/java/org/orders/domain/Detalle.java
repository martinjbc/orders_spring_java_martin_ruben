package org.orders.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="DETALLES")  
@Entity(name="detalle")
public class Detalle implements Serializable {
	
	@EmbeddedId
	private DetalleId idDetalle;
	
	//@Id
	@ManyToOne
	@JoinColumn(name="IDPEDIDO", nullable = true)
	@MapsId("IDPEDIDO")
	private Pedido pedido;

	//@Id
	@ManyToOne
	@JoinColumn(name="IDPRODUCTO", nullable = true)
	@MapsId("IDPRODUCTO")
	private Producto producto;

	@Column(name="Preciounidad")
	private double Preciounidad;

	@Column(name="Cantidad")
	private int Cantidad;

	@Column(name="Descuento")
	private int Descuento;

	public Detalle() {
		
	}
	
	public double getPreciounidad() {
		return Preciounidad;
	}

	public void setPreciounidad(double preciounidad) {
		Preciounidad = preciounidad;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public int getDescuento() {
		return Descuento;
	}

	public void setDescuento(int descuento) {
		Descuento = descuento;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Pedido getPedido() {
		return this.pedido;
	}
	
	public DetalleId getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(DetalleId idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
