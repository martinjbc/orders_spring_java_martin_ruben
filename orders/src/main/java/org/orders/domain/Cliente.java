package org.orders.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="CLIENTES")  
@Entity(name="cliente")
public class Cliente {
	@Id
	@Column(name="Idcliente")
	@GeneratedValue(generator = "clientes_seq")
	@SequenceGenerator(name="clientes_seq", sequenceName="clientes_seq",allocationSize=1)
	private int Idcliente;

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

	public int getIdcliente() {
		return Idcliente;
	}

	public void setIdcliente(int idcliente) {
		Idcliente = idcliente;
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
	
	
}
