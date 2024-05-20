package com.gestioncolegio.entity;

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
	
	@ManyToOne
	@JoinColumn(name = "rol", referencedColumnName = "id")
	private Rol rol;

	@ManyToMany
	@JoinTable(name = "profesor_asignaturas", joinColumns = @JoinColumn(name = "profesor_id"), inverseJoinColumns = @JoinColumn(name = "asignatura_id"))

	private List<Asignatura> asignaturas = new ArrayList<Asignatura>();

	
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}



	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

}
