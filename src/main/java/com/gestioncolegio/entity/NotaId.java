package com.gestioncolegio.entity;

import java.io.Serializable;
import java.util.Objects;

public class NotaId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer alumno;
	private Integer asignatura;

	public NotaId(Integer alumno, Integer asignatura) {
		super();
		this.alumno = alumno;
		this.asignatura = asignatura;
	}

	public NotaId() {
		super();
	}

	public Integer getAlumno() {
		return alumno;
	}

	public void setAlumno(Integer alumno) {
		this.alumno = alumno;
	}

	public Integer getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Integer asignatura) {
		this.asignatura = asignatura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumno, asignatura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaId other = (NotaId) obj;
		return Objects.equals(alumno, other.alumno) && Objects.equals(asignatura, other.asignatura);
	}

}
