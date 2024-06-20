package com.gestioncolegio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notas")
@IdClass(NotaId.class)
public class Nota {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "alumno_id", nullable = false, foreignKey = @ForeignKey(name = "fk_nota_alumno"))
	private Alumno alumno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "asignatura_id", nullable = false, foreignKey = @ForeignKey(name = "fk_nota_asignatura"))
	private Asignatura asignatura;

	@Column(nullable = false)
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
