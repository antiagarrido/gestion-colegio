package com.gestioncolegio.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "alumno_asignaturas")
public class AlumnoAsignatura implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AlumnoAsignaturaId id;

    @ManyToOne
    @MapsId("alumno_id")
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @MapsId("asignatura_id")
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    public AlumnoAsignaturaId getId() {
        return id;
    }

    public void setId(AlumnoAsignaturaId id) {
        this.id = id;
    }

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
}
