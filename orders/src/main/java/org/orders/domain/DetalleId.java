package org.orders.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetalleId implements Serializable {
	
	@Column(name="IDPEDIDO")
	private int idPedido;
	
	@Column(name="IDPRODUCTO")
	private int idProducto;
	
	public DetalleId() {
		
	}
	
	public DetalleId(int idPedido, int idProducto) {
		this.idPedido = idPedido;
		this.idProducto = idProducto;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}	
	
}
