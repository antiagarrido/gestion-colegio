package com.gestioncolegio.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;


@Embeddable
public class NotaId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int alumno_id;
	private int asignatura_id;
	
	public NotaId(int alumno_id, int asignatura_id) {
		super();
		this.alumno_id = alumno_id;
		this.asignatura_id = asignatura_id;
	}

	public NotaId() {
		super();
	}

	public int getAlumno_id() {
		return alumno_id;
	}

	public void setAlumno_id(int alumno_id) {
		this.alumno_id = alumno_id;
	}

	public int getAsignatura_id() {
		return asignatura_id;
	}

	public void setAsignatura_id(int asignatura_id) {
		this.asignatura_id = asignatura_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumno_id, asignatura_id);
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
		return alumno_id == other.alumno_id && asignatura_id == other.asignatura_id;
	}
	
	
	


}
