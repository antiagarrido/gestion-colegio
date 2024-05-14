package com.gestioncolegio.entity;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table( name = "director")
public class Director extends Trabajador {
	
	private int antiguedad_cargo;
	
	
	
	public Director(int id, String nombre, String apellidos, Date fNacimiento, String email, String direccion,
			String telefono, String dni, String iBAN, long sueldo, Date antiguedad, int antiguedad_cargo) {
		super(id, nombre, apellidos, fNacimiento, email, direccion, telefono, dni, iBAN, sueldo, antiguedad);
		this.antiguedad_cargo = antiguedad_cargo;
	}

	//Sin id 
	public Director(String dni, String nombre, String apellidos, String email, Date fNacimiento, String direccion,
			String telefono, String iBAN, long sueldo, Date antiguedad, int antiguedad_cargo) {
		super(dni, nombre, apellidos, email, fNacimiento, direccion, telefono, iBAN, sueldo, antiguedad);
		this.antiguedad_cargo = antiguedad_cargo;
	}
	
	

	public Director() {
		super();
	}

	public int getAntiguedad_cargo() {
		return antiguedad_cargo;
	}

	public void setAntiguedad_cargo(int antiguedad_cargo) {
		this.antiguedad_cargo = antiguedad_cargo;
	}


	

}
