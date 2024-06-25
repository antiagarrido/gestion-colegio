package com.gestioncolegio.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AlumnoAsignaturaId implements Serializable {
    private static final long serialVersionUID = 1L;

    private int alumno_id;
    private int asignatura_id;

    public AlumnoAsignaturaId() {}

    public AlumnoAsignaturaId(int alumno_id, int asignatura_id) {
        this.alumno_id = alumno_id;
        this.asignatura_id = asignatura_id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoAsignaturaId that = (AlumnoAsignaturaId) o;
        return alumno_id == that.alumno_id && asignatura_id == that.asignatura_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(alumno_id, asignatura_id);
    }
}

