package org.orders.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="PRODUCTOS")  
@Entity(name="producto")
public class Producto {
	@Id
	@Column(name="IDPRODUCTO")
	@GeneratedValue(generator = "producto_seq")
	@SequenceGenerator(name="producto_seq", sequenceName="producto_seq",allocationSize=1)
	 private int idProducto;
	
	@Column(name="nombreproducto")
     private String nombreproducto;
		
	@Column(name="preciounidad")
     private double precio;
	
	@Column(name="stock")
     private int stock;
	
	@Column(name="suspendido")
    private int suspendido;
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreproducto() {
		return nombreproducto;
	}
	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getSuspendido() {
		return suspendido;
	}
	public void setSuspendido(int suspendido) {
		this.suspendido = suspendido;
	}

}
