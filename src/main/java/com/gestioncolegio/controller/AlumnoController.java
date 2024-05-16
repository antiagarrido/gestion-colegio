package com.gestioncolegio.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.gestioncolegio.entity.Alumno;
import com.gestioncolegio.entity.Asignatura;
import com.gestioncolegio.service.AlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping("/test")
	public ResponseEntity<String> prueba() {
		
		return ResponseEntity.ok("Funciona");
	}

	@GetMapping
	public ResponseEntity<List<Alumno>> obtenerAlumnos() {
		try {
			List<Alumno> alumnos = alumnoService.listarAlumnos();
			
			return ResponseEntity.ok(alumnos);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Alumno> getAlumno(@PathVariable int id) {
		try {
			Alumno alumno = alumnoService.buscarAlumnoId(id);
			
			return ResponseEntity.ok(alumno);
		} catch (Exception e) {
			return ResponseEntity.status(404).body(null);
		}
	}

	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<Alumno> getAlumnoPorNombre(@PathVariable String nombre) {
		try {
			Alumno alumno = alumnoService.buscarAlumnoNombre(nombre);
			
			return ResponseEntity.ok(alumno);
			
		} catch (Exception e) {
			return ResponseEntity.status(404).body(null);
		}
	}

	@PostMapping
	public ResponseEntity<Alumno> nuevoAlumno(@RequestBody Alumno alumno) {
		try {
			alumnoService.guardar(alumno);
			
			return ResponseEntity.ok(alumno);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(null);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Alumno> actualizarAlumno(@PathVariable int id, @RequestBody Alumno alumno) {
		try {
			alumno.setId(id);
			alumnoService.guardar(alumno);
			
			return ResponseEntity.ok(alumno);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(null);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarAlumno(@PathVariable int id) {

		try {
			alumnoService.eliminar(id);
			
			return ResponseEntity.ok(null);
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	@PostMapping("/{alumnoId}/asignaturas/{asignaturaId}")
	public ResponseEntity<Alumno> matricularAsignatura(@PathVariable int alumnoId, @PathVariable int asignaturaId) {

		try {
			Alumno alumno = alumnoService.matricularAsignatura(alumnoId, asignaturaId);
			
			return ResponseEntity.ok(alumno);

		} catch (Exception e) {
			return ResponseEntity.status(400).body(null);
		}
	}

	@DeleteMapping("/{alumnoId}/asignaturas/{asignaturaId}")
	public ResponseEntity<Alumno> desmatricularAsignatura(@PathVariable int alumnoId, @PathVariable int asignaturaId) {

		try {
			Alumno alumno = alumnoService.desmatricularAsignatura(alumnoId, asignaturaId);
			
			return ResponseEntity.ok(alumno);

		} catch (Exception e) {
			return ResponseEntity.status(400).body(null);
		}
	}

	@GetMapping("/{alumnoId}/asignaturas")
	public ResponseEntity<List<Asignatura>> consultarAsignaturas(@PathVariable int alumnoId) {

		try {
			List<Asignatura> asignaturas = alumnoService.consultarAsignaturas(alumnoId);
			
			return ResponseEntity.ok(asignaturas);

		} catch (Exception e) {
			return ResponseEntity.status(404).body(null);
		}
	}
}
