package com.gestioncolegio.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "asignaturas")
public class Asignatura implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String curso;

    @ManyToMany(mappedBy = "asignaturasMatriculadas")
    private List<Alumno> alumnos = new ArrayList<Alumno>();

    @ManyToMany(mappedBy =  "asignaturas")
    private List<Trabajador> profesores = new ArrayList<Trabajador>();

   
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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





}
