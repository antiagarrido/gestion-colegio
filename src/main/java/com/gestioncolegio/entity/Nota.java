package com.gestioncolegio.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "notas")
public class Nota implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NotaId id;

	@ManyToOne
	@JoinColumn(name = "alumno_id", insertable=false, updatable=false, foreignKey = @ForeignKey(name = "fk_nota_alumno"))
	private Alumno alumno;

	@ManyToOne
	@JoinColumn(name = "asignatura_id", insertable=false, updatable=false, foreignKey = @ForeignKey(name = "fk_nota_asignatura"))
	private Asignatura asignatura;

	
	private Double nota;

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

}
