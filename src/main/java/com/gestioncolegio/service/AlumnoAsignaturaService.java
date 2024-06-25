package com.gestioncolegio.service;

import org.springframework.stereotype.Service;

import com.gestioncolegio.entity.Alumno;
import com.gestioncolegio.entity.AlumnoAsignatura;
import com.gestioncolegio.entity.AlumnoAsignaturaId;
import com.gestioncolegio.entity.Asignatura;
import com.gestioncolegio.repository.AlumnoAsignaturaRepository;
import com.gestioncolegio.repository.AlumnoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlumnoAsignaturaService {
	@Autowired
	private AlumnoAsignaturaRepository alumnoAsignaturaRepository;
	  @Autowired
	    private AlumnoRepository alumnoRepository;

	public List<AlumnoAsignatura> getAllAlumnoAsignaturas() {
		return alumnoAsignaturaRepository.findAll();
	}
	


	public Optional<AlumnoAsignatura> getAlumnoAsignaturaById(AlumnoAsignaturaId id) {
		return alumnoAsignaturaRepository.findById(id);
	}

	public AlumnoAsignatura saveAlumnoAsignatura(AlumnoAsignatura alumnoAsignatura) {
		return alumnoAsignaturaRepository.save(alumnoAsignatura);
	}

	public void deleteAlumnoAsignatura(AlumnoAsignaturaId id) {
		alumnoAsignaturaRepository.deleteById(id);
		
		
	}
	
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }
    
    public List<Asignatura> getAsignaturasByAlumnoId(int alumno_id) {
        return alumnoAsignaturaRepository.findByIdAlumnoId(alumno_id)
                .stream()
                .map(AlumnoAsignatura::getAsignatura)
                .collect(Collectors.toList());
    }
}
