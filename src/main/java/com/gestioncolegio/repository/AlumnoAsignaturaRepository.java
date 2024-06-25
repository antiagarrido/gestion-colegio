package com.gestioncolegio.repository;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestioncolegio.entity.AlumnoAsignatura;
import com.gestioncolegio.entity.AlumnoAsignaturaId;

public interface AlumnoAsignaturaRepository extends JpaRepository<AlumnoAsignatura, AlumnoAsignaturaId> {


	Collection<AlumnoAsignatura> findByIdAlumnoId(int alumno_id);

}
