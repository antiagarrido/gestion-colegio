package com.gestioncolegio.entity;
import java.sql.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Persona {
	
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private String email;
	private String direccion;
	private String telefono;
	private String dni;
	
	
	public Persona() {
		super();
	}
	
	public Persona(int id, String nombre, String apellidos, Date fNacimiento, String email, String direccion,
			String telefono, String dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fNacimiento;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
	}



	
	//Constructor con todos los parámetros menos id
	public Persona(String dni, String nombre, String apellidos, String email, Date fNacimiento, String direccion,
			String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	
	
	//GETTERS & SETTERS


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getfNacimiento() {
		return fechaNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fechaNacimiento = fNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return " Nombre= " + nombre + "\n Apellidos= " + apellidos + "\n Fecha de nacimiento= " + fechaNacimiento + "\n email= "
				+ email + "\n Direccion= " + direccion + "\n Teléfono= " + telefono + "\n DNI= " + dni +"\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	


	
	
	
	
	

}
