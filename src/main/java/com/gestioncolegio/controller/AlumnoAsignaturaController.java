package com.gestioncolegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestioncolegio.entity.Alumno;
import com.gestioncolegio.entity.Asignatura;
import com.gestioncolegio.service.AlumnoAsignaturaService;

@RestController
@RequestMapping("/alumno_asignaturas")
public class AlumnoAsignaturaController {

    @Autowired
    private AlumnoAsignaturaService alumnoAsignaturaService;

    @GetMapping("/alumnos")
    public List<Alumno> getAllAlumnos() {
        return alumnoAsignaturaService.getAllAlumnos();
    }

    @GetMapping("/alumnos/{alumnoId}/asignaturas")
    public List<Asignatura> getAsignaturasByAlumnoId(@PathVariable int alumnoId) {
        return alumnoAsignaturaService.getAsignaturasByAlumnoId(alumnoId);
    }
}