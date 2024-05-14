package com.gestioncolegio.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "profesores")
public class Profesor extends Trabajador {

	@ManyToMany
	@JoinTable(name = "profesor_asignaturas", joinColumns = @JoinColumn(name = "profesor_id"), inverseJoinColumns = @JoinColumn(name = "asignatura_id"))

	private List<Asignatura> asignaturas = new ArrayList<Asignatura>();

	public Profesor(int id, String nombre, String apellidos, Date fNacimiento, String email, String direccion,
			String telefono, String dni, String iBAN, long sueldo, Date antiguedad) {
		super(id, nombre, apellidos, fNacimiento, email, direccion, telefono, dni, iBAN, sueldo, antiguedad);
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}
     //Pte evitar repetidos
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	
	

}
