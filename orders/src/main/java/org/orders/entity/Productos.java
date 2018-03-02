package org.orders.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="PRODUCTOS")  
@Entity
public class Productos {
	@Id
	@Column(name="idProducto")
	@GeneratedValue(generator = "producto_seq")
	@SequenceGenerator(name="producto_seq", sequenceName="producto_seq",allocationSize=1)
	 private int idProducto;
	
	@Column(name="nombreproducto")
     private String nombreproducto;
	
	@Column(name="idProveedor")
     private int idProveedor;
	
	@Column(name="idCategoria")
     private int idCategoria;
	
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
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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
