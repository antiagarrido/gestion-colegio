package com.gestioncolegio.entity;


import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table( name = "trabajadores")
@Inheritance(strategy = InheritanceType.JOINED)
public class Trabajador extends Persona {

	private String iban;
	private long sueldo;
	private Date antiguedad;
	
	
	
    //Constructor con todos los atributos
	public Trabajador(int id, String nombre, String apellidos, Date fNacimiento, String email, String direccion,
			String telefono, String dni, String iban, long sueldo, Date antiguedad) {
		super(id, nombre, apellidos, fNacimiento, email, direccion, telefono, dni);
		this.setIban(iban);
		this.sueldo = sueldo;
		this.antiguedad = antiguedad;
	}


	// Constructor con todos los atributos menos id 
	public Trabajador(String dni, String nombre, String apellidos, String email, Date fNacimiento, String direccion,
			String telefono, String iban, long sueldo, Date antiguedad) {
		super(dni, nombre, apellidos, email, fNacimiento, direccion, telefono);
		this.setIban(iban);
		this.sueldo = sueldo;
		this.antiguedad = antiguedad;
	}

	

	public Trabajador() {
		super();
		// TODO Auto-generated constructor stub
	}


	//Getters & setters
	

	public long getSueldo() {
		return sueldo;
	}

	public void setSueldo(long sueldo) {
		this.sueldo = sueldo;
	}

	public Date getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Date antiguedad) {
		this.antiguedad = antiguedad;
	}


	public String getIban() {
		return iban;
	}


	public void setIban(String iban) {
		this.iban = iban;
	}

}
