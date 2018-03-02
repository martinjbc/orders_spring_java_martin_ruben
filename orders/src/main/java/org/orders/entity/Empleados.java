package org.orders.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="EMPLEADOS")  
@Entity
public class Empleados {
	@Id
	@Column(name="Idempleado")
	@GeneratedValue(generator = "empleados_seq")
	@SequenceGenerator(name="empleados_seq", sequenceName="empleados_seq",allocationSize=1)
	private int Idempleado;

	@Column(name="Apellidos")
	private String Apellidos;

	@Column(name="Nombre")
	private String Nombre;

	@Column(name="Cargo")
	private String Cargo;

	@Column(name="Fechacontratacion")
	private Date Fechacontratacion;

	@Column(name="Direccion")
	private String Direccion;

	@Column(name="Ciudad")
	private String Ciudad;

	@Column(name="Pais")
	private String Pais;

	@Column(name="Teldomicilio")
	private String Teldomicilio;

	public int getIdempleado() {
		return Idempleado;
	}

	public void setIdempleado(int idempleado) {
		Idempleado = idempleado;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
	}

	public Date getFechacontratacion() {
		return Fechacontratacion;
	}

	public void setFechacontratacion(Date fechacontratacion) {
		Fechacontratacion = fechacontratacion;
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

	public String getTeldomicilio() {
		return Teldomicilio;
	}

	public void setTeldomicilio(String teldomicilio) {
		Teldomicilio = teldomicilio;
	}
	
	
}
