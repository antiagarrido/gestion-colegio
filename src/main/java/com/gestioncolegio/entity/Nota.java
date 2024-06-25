package com.gestioncolegio.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "notas")
public class Nota implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private NotaId id;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "alumno_id", referencedColumnName = "alumno_id", insertable = false, updatable = false),
        @JoinColumn(name = "asignatura_id", referencedColumnName = "asignatura_id", insertable = false, updatable = false)
    })
    private AlumnoAsignatura alumnoAsignatura;

    private Double nota;

    public NotaId getId() {
        return id;
    }

    public void setId(NotaId id) {
        this.id = id;
    }

    public AlumnoAsignatura getAlumnoAsignatura() {
        return alumnoAsignatura;
    }

    public void setAlumnoAsignatura(AlumnoAsignatura alumnoAsignatura) {
        this.alumnoAsignatura = alumnoAsignatura;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
