package com.gestioncolegio.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<?> getAlumnos() {
		try {
			List<Alumno> alumnos = alumnoService.listarAlumnos();
			
			if(alumnos.isEmpty()) {
				return ResponseEntity.status(404).body("Todavía no tenemos alumnos");
			}

			return ResponseEntity.ok(alumnos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener los alumnos." +  e.getMessage());
		}
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getAlumno(@PathVariable int id) {
		try {
			Alumno alumno = alumnoService.buscarAlumnoId(id);
			
			if(alumno ==null) {
				return ResponseEntity.status(404).body("No existe el alumno con id " + id);
			}else {

			return ResponseEntity.ok(alumno);
		}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener el alumno." +  e.getMessage());
		}
	}

	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<?> getAlumnoPorNombre(@PathVariable String nombre) {
		try {
			
			List<Alumno> alumnos = alumnoService.buscarAlumnoNombre(nombre);
			if(alumnos.isEmpty()) {
				return ResponseEntity.status(404).body("Todavía no tenemos alumnos");
			} else {
				
			return ResponseEntity.ok(alumnos);}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener el alumno." +  e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<?> createAlumno(@RequestBody Alumno alumno) {
		try {
			
			Alumno alumnoNuevo = alumnoService.guardar(alumno);

			return ResponseEntity.ok(alumnoNuevo);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el alumno." +  e.getMessage());
		}
	}

	@PutMapping                                                                                
	public ResponseEntity<?> updateAlumno( @RequestBody Alumno alumno) {
		try {
			
			Alumno alumnoActualizado = alumnoService.guardar(alumno);

			return ResponseEntity.ok(alumnoActualizado);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el alumno." +  e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAlumno(@PathVariable int id) {

		try {
			
			alumnoService.eliminar(id);

			return ResponseEntity.ok("Alumno " + id + " eliminado correctamente");
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se ha podido elimanr el alumno");
		}
	}

	// Asignaturas

	@GetMapping("/{alumnoId}/asignaturas")
	public ResponseEntity<?> consultarAsignaturas(@PathVariable int alumnoId) {

		try {
			List<Asignatura> asignaturas = alumnoService.consultarAsignaturas(alumnoId);

			return ResponseEntity.ok(asignaturas);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener las asignaturas el alumno." +  e.getMessage());
		}
	}

	@PostMapping("/asignaturas")
	public ResponseEntity<?> matricularAsignatura(@RequestBody Map <String, Integer> mapaAlumAsig) {

		try {
			int alumno_id = mapaAlumAsig.get("alumno_id");
			int asignatura_id = mapaAlumAsig.get("asignatura_id");
			Alumno alumno = alumnoService.matricularAsignatura(alumno_id, asignatura_id);

			return ResponseEntity.ok(alumno);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al matricular el alummno en la asignatura" +  e.getMessage());
		}
	}

	@DeleteMapping("/asignaturas")
	public ResponseEntity<?> desmatricularAsignatura(@RequestBody Map <String, Integer> mapaAlumAsig) {

		try {
			int alumno_id = mapaAlumAsig.get("alumno_id");
			int asignatura_id = mapaAlumAsig.get("asignatura_id");
			Alumno alumno = alumnoService.desmatricularAsignatura(alumno_id, asignatura_id);

			return ResponseEntity.ok(alumno);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al desmatricular el alummno de la asignatura" +  e.getMessage());
		}
	}

}
