package com.gestioncolegio.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "alumnos")

public class Alumno extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToMany
	@JoinTable(name = "alumno_asignaturas", joinColumns = @JoinColumn(name = "alumno_id"), inverseJoinColumns = @JoinColumn(name = "asignatura_id"))

	private List<Asignatura> asignaturasMatriculadas = new ArrayList<Asignatura>();

	public Alumno(int id, String nombre, String apellidos, Date fNacimiento, String email, String direccion,
			String telefono, String dni) {
		super(id, nombre, apellidos, fNacimiento, email, direccion, telefono, dni);
	

	}

	// Constructor con todos los parámetrosmenos id
	public Alumno(String dni, String nombre, String apellidos, String email, Date fNacimiento, String direccion,
			String telefono) {
		super(dni, nombre, apellidos, email, fNacimiento, direccion, telefono);
	}

	public Alumno() {
		super();
	}

	@Override
	public String toString() {

		return "\n Alumno " + this.getId() + " : \n" + super.toString();
	}

	public List<Asignatura> getAsignaturasMatriculadas() {
		return asignaturasMatriculadas;
	}
	
	//Falta comprobar si la asignatura está en la lista
	public void setAsignaturasMatriculadas(List<Asignatura> asignaturasMatriculadas) {
		this.asignaturasMatriculadas = asignaturasMatriculadas;
	}

}
