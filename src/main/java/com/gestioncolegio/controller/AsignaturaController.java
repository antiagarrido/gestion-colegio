package com.gestioncolegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestioncolegio.entity.Asignatura;
import com.gestioncolegio.service.AsignaturaService;


@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {
	@Autowired
	private AsignaturaService asignaturaService;

	@GetMapping("/test")
	public ResponseEntity<String> prueba() {
		return ResponseEntity.ok("Funciona");
	}

	@GetMapping
	public ResponseEntity<?> getAsignaturas() {
		try {
			List<Asignatura> asignaturas = asignaturaService.listarAsignaturas();
			return ResponseEntity.ok(asignaturas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener las asignaturas" +  e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAsignatura(@PathVariable int id) {
		try {
			Asignatura asignatura = asignaturaService.buscarAsignaturaId(id);

			return ResponseEntity.ok(asignatura);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener la asignatura" +  e.getMessage());
		}
	}

	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<?> getAsignaturaPorNombre(@PathVariable String nombre) {
		try {
			List<Asignatura> asignaturas = asignaturaService.buscarAsignaturaNombre(nombre);

			return ResponseEntity.ok(asignaturas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener la asignatura" +  e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<?> createAsignatura(@RequestBody Asignatura asignatura) {
		try {
			Asignatura nuevaAsignatura= asignaturaService.guardar(asignatura);

			return ResponseEntity.ok(nuevaAsignatura);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la asignatura" +  e.getMessage());
		}
	}

	@PutMapping()
	public ResponseEntity<?> updateAsignatura( @RequestBody Asignatura asignatura) {
		try {

			Asignatura asignaturaActualizada = asignaturaService.guardar(asignatura);

			return ResponseEntity.ok(asignaturaActualizada);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la asignatura" +  e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAsignatura(@PathVariable int id) {
		try {
			asignaturaService.eliminar(id);
			return ResponseEntity.ok(" Asignatura " + id + " eliminada correctamente");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la asignatura" +  e.getMessage());
		}
	}

}
