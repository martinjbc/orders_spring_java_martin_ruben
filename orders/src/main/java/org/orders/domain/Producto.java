package org.orders.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Table(name="PRODUCTOS")  
@Entity(name="producto")
public class Producto {
	@Id
	@Column(name="IDPRODUCTO")
	@GeneratedValue(generator = "productos_seq")
	@SequenceGenerator(name="productos_seq", sequenceName="productos_seq",allocationSize=1)
	 private int idProducto;
	
	@NotBlank(message="Nombre Producto")
	@Size(min=3, max=250,message="La longitud debe ser entre 3 y 250")
	@Pattern(regexp = "^[A-Za-zñÑ0-9#&\\-\\s]+$", message = "Solo se admiten letras mayúsculas")
	@Column(name="nombreproducto")
     private String nombreproducto;
	
	@ManyToOne
	@JoinColumn(name="IDPROVEEDOR", nullable = true)
	private Proveedores proveedores;
	
	@ManyToOne
	@JoinColumn(name="IDCATEGORIA", nullable = true)
	private Categorias categorias;
	
	
	@NotNull(message="Precio Unidad")
	@NumberFormat(style = Style.NUMBER)
	@DecimalMin(value = "1.0", inclusive = true,message="El stock debe ser como mínimo 1.0")
	@DecimalMax(value = "1999.9", inclusive = true,message="El stock debe ser como máximo 1999.9")
	@Column(name="preciounidad")
     private double precio;
	
	@NotNull(message="Stock")
	@Column(name="stock")
     private int stock;
	
	@NotNull(message="Suspendido")
	@Range(min=0, max=1,message="Suspendido deber ser 0 ó 1")
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
	public Proveedores getProveedores() {
		return proveedores;
	}
	public void setProveedores(Proveedores proveedores) {
		this.proveedores = proveedores;
	}
	public Categorias getCategorias() {
		return categorias;
	}
	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}



}
