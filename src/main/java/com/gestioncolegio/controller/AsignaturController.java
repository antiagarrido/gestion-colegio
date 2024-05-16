package com.gestioncolegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestioncolegio.entity.Asignatura;
import com.gestioncolegio.service.AsignaturaService;

public class AsignaturController {
	@Autowired
	private AsignaturaService asignaturaService;

	@GetMapping("/test")
	public ResponseEntity<String> prueba() {
		return ResponseEntity.ok("Funciona");
	}

	@GetMapping
	public ResponseEntity<List<Asignatura>> obtenerAsignaturas() {
		try {
			List<Asignatura> asignaturas = asignaturaService.listarAsignaturas();
			return ResponseEntity.ok(asignaturas);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Asignatura> getAsignatura(@PathVariable int id) {
		try {
			Asignatura asignatura = asignaturaService.buscarAsignaturaId(id);

			return ResponseEntity.ok(asignatura);
		} catch (Exception e) {
			return ResponseEntity.status(404).body(null);
		}
	}

	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<Asignatura> getAsignaturaPorNombre(@PathVariable String nombre) {
		try {
			Asignatura asignatura = asignaturaService.buscarAsignaturaNombre(nombre);

			return ResponseEntity.ok(asignatura);
		} catch (Exception e) {
			return ResponseEntity.status(404).body(null);
		}
	}

	@PostMapping
	public ResponseEntity<Asignatura> nuevaAsignatura(@RequestBody Asignatura asignatura) {
		try {
			asignaturaService.guardar(asignatura);

			return ResponseEntity.ok(asignatura);

		} catch (Exception e) {
			return ResponseEntity.status(400).body(null);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Asignatura> actualizarAsignatura(@PathVariable int id, @RequestBody Asignatura asignatura) {
		try {
			asignatura.setId(id);
			asignaturaService.guardar(asignatura);

			return ResponseEntity.ok(asignatura);

		} catch (Exception e) {
			return ResponseEntity.status(400).body(null);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarAsignatura(@PathVariable int id) {
		try {
			asignaturaService.eliminar(id);
			return ResponseEntity.noContent().build();

		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

}
