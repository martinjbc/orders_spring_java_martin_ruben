package org.orders.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="PROVEEDORES")  
@Entity
public class Proveedores {
	@Id
	@Column(name="Idproveedor")
	@GeneratedValue(generator = "proveedores_seq")
	@SequenceGenerator(name="proveedores_seq", sequenceName="proveedores_seq",allocationSize=1)
	private int Idproveedor;

	@Column(name="Nombrecompania")
	private String Nombrecompania;

	@Column(name="Direccion")
	private String Direccion;

	@Column(name="Ciudad")
	private String Ciudad;

	@Column(name="Pais")
	private String Pais;

	@Column(name="Telefono")
	private String Telefono;

	@Column(name="Fax")
	private String Fax;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="IDPROVEEDOR", nullable = true)
	private Set<Producto> productos = new HashSet<Producto>();
	
	public int getIdproveedor() {
		return Idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		Idproveedor = idproveedor;
	}

	public String getNombrecompania() {
		return Nombrecompania;
	}

	public void setNombrecompania(String nombrecompania) {
		Nombrecompania = nombrecompania;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
	
}
