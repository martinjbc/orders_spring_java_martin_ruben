package org.orders.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Table(name="CATEGORIAS")  
@Entity
public class Categorias {
	@Id
	@Column(name="Idcategoria")
	@GeneratedValue(generator = "categorias_seq")
	@SequenceGenerator(name="categorias_seq", sequenceName="categorias_seq",allocationSize=1)
	private int Idcategoria;
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorias_seq")
	
	@Column(name="Nombrecategoria")
	private String Nombrecategoria;
	
	@Column(name="Descripcion")
	private String Descripcion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="IDCATEGORIA", nullable = true)
	 private Set<Producto> productos = new HashSet<Producto>();
	
	public int getIdcategoria() {
		return Idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		Idcategoria = idcategoria;
	}
	public String getNombrecategoria() {
		return Nombrecategoria;
	}
	public void setNombrecategoria(String nombrecategoria) {
		Nombrecategoria = nombrecategoria;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Set<Producto> getProductos() {
		return productos;
	}
	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
}
