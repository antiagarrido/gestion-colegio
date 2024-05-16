package com.gestioncolegio.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestioncolegio.entity.Alumno;
import com.gestioncolegio.entity.Asignatura;
import com.gestioncolegio.repository.AlumnoRepository;

@Service
public class AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;

	@Autowired
	private AsignaturaService asignaturaService;

	public List<Alumno> listarAlumnos() {
		return alumnoRepository.findAll();
	}

	public Alumno buscarAlumnoId(int id) {
		return alumnoRepository.findById(id);

	}

	public Alumno buscarAlumnoNombre(String nombre) {
		return alumnoRepository.findByNombre(nombre);
	}

	public void guardar(Alumno alumno) {
		alumnoRepository.save(alumno);
	}

	public void eliminar(int id) {
		alumnoRepository.deleteById(id);
	}
	
	public List<Asignatura> consultarAsignaturas(int alumno_id) {
		Alumno alumno = buscarAlumnoId(alumno_id);
		
		return alumno.getAsignaturasMatriculadas();
	}

	public Alumno matricularAsignatura(int alumno_id, int asignatura_id) {
		Alumno alumno = buscarAlumnoId(alumno_id);
		Asignatura asignatura = asignaturaService.buscarAsignaturaId(asignatura_id);

		alumno.getAsignaturasMatriculadas().add(asignatura);
		return alumnoRepository.save(alumno);
	}

	public Alumno desmatricularAsignatura(int alumno_id, int asignatura_id) {
		
		Alumno alumno =buscarAlumnoId(alumno_id);
		Asignatura asignatura = asignaturaService.buscarAsignaturaId(asignatura_id);

		alumno.getAsignaturasMatriculadas().remove(asignatura);
		return alumnoRepository.save(alumno);
	}



}
