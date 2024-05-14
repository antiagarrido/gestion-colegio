package com.gestioncolegio.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table( name = "bedeles")
public class Bedel extends Trabajador {

	private String zona;

	//Constructor con todos los atributos
	public Bedel(int id, String nombre, String apellidos, Date fNacimiento, String email, String direccion,
			String telefono, String dni, String iBAN, long sueldo, Date antiguedad, String zona) {
		super(id, nombre, apellidos, fNacimiento, email, direccion, telefono, dni, iBAN, sueldo, antiguedad);
		this.zona = zona;
	}


	// Constructor sin id
	public Bedel(String dni, String nombre, String apellidos, String email, Date fNacimiento, String direccion,
			String telefono, String iBAN, long sueldo, Date antiguedad, String zona) {
		super(dni, nombre, apellidos, email, fNacimiento, direccion, telefono, iBAN, sueldo, antiguedad);
		this.zona = zona;

	}


	public Bedel() {
		// TODO Auto-generated constructor stub
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

}
