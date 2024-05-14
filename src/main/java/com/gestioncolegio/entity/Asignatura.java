package com.gestioncolegio.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "asignaturas")
public class Asignatura {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String curso;

    @ManyToMany(mappedBy = "asignaturasMatriculadas")
    private List<Alumno> alumnos = new ArrayList<Alumno>();

    @ManyToMany(mappedBy = "asignaturas")
    private List<Profesor> profesores = new ArrayList<Profesor>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "" + nombre + " de " + curso + "( id " + id + ")";
	}



}
