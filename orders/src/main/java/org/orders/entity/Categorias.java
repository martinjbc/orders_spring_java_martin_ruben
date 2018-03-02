package org.orders.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	
}
