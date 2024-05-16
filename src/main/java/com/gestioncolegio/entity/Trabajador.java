package com.gestioncolegio.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "trabajadores")
@Inheritance(strategy = InheritanceType.JOINED)
public class Trabajador extends Persona {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String iban;
	private long sueldo;
	private int antiguedad;
	private String rol;

	@ManyToMany
	@JoinTable(name = "profesor_asignaturas", joinColumns = @JoinColumn(name = "profesor_id"), inverseJoinColumns = @JoinColumn(name = "asignatura_id"))

	private List<Asignatura> asignaturas = new ArrayList<Asignatura>();

	// Constructor con todos los atributos
	public Trabajador(int id, String nombre, String apellidos, Date fNacimiento, String email, String direccion,
			String telefono, String dni, String iban, long sueldo, int antiguedad, String rol) {
		super(id, nombre, apellidos, fNacimiento, email, direccion, telefono, dni);
		this.setIban(iban);
		this.sueldo = sueldo;
		this.antiguedad = antiguedad;
		this.rol = rol;
	}

	// Constructor con todos los atributos menos id
	public Trabajador(String dni, String nombre, String apellidos, String email, Date fNacimiento, String direccion,
			String telefono, String iban, long sueldo, int antiguedad, String rol) {
		super(dni, nombre, apellidos, email, fNacimiento, direccion, telefono);
		this.setIban(iban);
		this.sueldo = sueldo;
		this.antiguedad = antiguedad;
		this.rol = rol;
	}

	public Trabajador() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Getters & setters

	public long getSueldo() {
		return sueldo;
	}

	public void setSueldo(long sueldo) {
		this.sueldo = sueldo;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {

		return "\n Trabajador " + this.getId() + " : \n" + super.toString() + " Puesto:" + this.getRol()
				+ "\n Antigüedad: " + this.getAntiguedad() + "\n";

	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

}
