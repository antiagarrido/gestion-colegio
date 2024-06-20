package com.gestioncolegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestioncolegio.entity.Nota;
import com.gestioncolegio.entity.NotaId;
import com.gestioncolegio.service.NotaService;

@RestController
@RequestMapping("/notas")
public class NotaController {
	@Autowired
	private NotaService notaService;

	@GetMapping("/{alumnoId}/{asignaturaId}")
	public ResponseEntity<?> getNotaById(@PathVariable Integer alumnoId, @PathVariable Integer asignaturaId) {

		NotaId id = new NotaId(alumnoId, asignaturaId);

		try {
			Nota nota = notaService.getNotaById(id);

			return ResponseEntity.ok(nota);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al obtener la nota" + e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<?> saveNota(@RequestBody Nota nota) {
		try {
			Nota nuevaNota = notaService.saveNota(nota);

			return ResponseEntity.ok(nuevaNota);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al crear la nota" + e.getMessage());
		}

	}

	@DeleteMapping("/{alumnoId}/{asignaturaId}")
	public ResponseEntity<?> deleteNota(@PathVariable Integer alumnoId, @PathVariable Integer asignaturaId) {
		NotaId id = new NotaId(alumnoId, asignaturaId);
		try {
			notaService.deleteNota(id);
			return ResponseEntity.ok(" Nota eliminada correctamente");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al eliminar la nota" + e.getMessage());
		}
	}

	// Buscar notas por alumnoId
	@GetMapping("/alumno/{alumnoId}")
	public ResponseEntity<?> getNotasByAlumnoId(@PathVariable Integer alumnoId) {
		try {
			List<Nota> notas = notaService.getNotasByAlumnoId(alumnoId);
			return ResponseEntity.ok(notas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al obtener las notas del alumno" + e.getMessage());
		}

	}

	// Buscar notas por asignaturaId
	@GetMapping("/asignatura/{asignaturaId}")
	public ResponseEntity<?> getNotasByAsignaturaId(@PathVariable Integer asignaturaId) {
		try {
			List<Nota> notas = notaService.getNotasByAsignaturaId(asignaturaId);
			return ResponseEntity.ok(notas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al obtener las notas de la asignatura" + e.getMessage());
		}
	}

}
