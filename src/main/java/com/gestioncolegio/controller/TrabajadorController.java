package com.gestioncolegio.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestioncolegio.entity.Asignatura;
import com.gestioncolegio.entity.Trabajador;
import com.gestioncolegio.service.TrabajadorService;

@RestController
@RequestMapping("/trabajadores")
public class TrabajadorController {

	@Autowired
	private TrabajadorService trabajadorService;

	@GetMapping("/test")
	public ResponseEntity<String> prueba() {
		return ResponseEntity.ok("Funciona");
	}

	@GetMapping
	public ResponseEntity<List<Trabajador>> obtenerTrabajadores() {

		try {
			List<Trabajador> trabajadores = trabajadorService.listarTrabajadores();

			return ResponseEntity.ok(trabajadores);

		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}

	@GetMapping("/director")
	public ResponseEntity<String> obtenerDirector() {
		try {
			Trabajador director = trabajadorService.buscarDirector();

			return ResponseEntity.ok("El director es " + director);

		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error " + e.getMessage());
		}
	}

	@GetMapping("/bedeles")
	public ResponseEntity<List<Trabajador>> obtenerBedeles() {
		try {
			List<Trabajador> bedeles = trabajadorService.buscarBedeles();

			return ResponseEntity.ok(bedeles);

		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}

	}

	@GetMapping("/profesores")
	public ResponseEntity<List<Trabajador>> obtenerProfesores() {
		try {
			List<Trabajador> profesores = trabajadorService.buscarProfesores();

			return ResponseEntity.ok(profesores);

		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Trabajador> getTrabajador(@PathVariable int id) {
		try {
			Trabajador trabajador = trabajadorService.buscarTrabajadorId(id);

			return ResponseEntity.ok(trabajador);
		} catch (Exception e) {
			return ResponseEntity.status(404).body(null);
		}
	}

	@PostMapping
	public ResponseEntity<Trabajador> nuevoTrabajador(@RequestBody Trabajador trabajador) {
		try {
			trabajadorService.guardar(trabajador);

			return ResponseEntity.ok(trabajador);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(null);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Trabajador> actualizarTrabajador(@PathVariable int id, @RequestBody Trabajador trabajador) {
		try {
			trabajador.setId(id);
			trabajadorService.guardar(trabajador);

			return ResponseEntity.ok(trabajador);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(null);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarTrabajador(@PathVariable int id) {
		try {
			trabajadorService.eliminar(id);

			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	@PostMapping("/{trabajadorId}/asignaturas/{asignaturaId}")
	public ResponseEntity<Trabajador> agregarAsignatura(@PathVariable int trabajadorId,
			@PathVariable int asignaturaId) {
		try {
			Trabajador trabajador = trabajadorService.agregarAsignatura(trabajadorId, asignaturaId);

			return ResponseEntity.ok(trabajador);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(null);
		}
	}

	@DeleteMapping("/{trabajadorId}/asignaturas/{asignaturaId}")
	public ResponseEntity<Trabajador> eliminarAsignatura(@PathVariable int trabajadorId,
			@PathVariable int asignaturaId) {
		try {
			Trabajador trabajador = trabajadorService.eliminarAsignatura(trabajadorId, asignaturaId);

			return ResponseEntity.ok(trabajador);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(null);
		}
	}

	@GetMapping("/{trabajadorId}/asignaturas")
	public ResponseEntity<List<Asignatura>> consultarAsignaturas(@PathVariable int trabajadorId) {
		try {
			List<Asignatura> asignaturas = trabajadorService.consultarAsignaturas(trabajadorId);

			return ResponseEntity.ok(asignaturas);
		} catch (Exception e) {
			return ResponseEntity.status(404).body(null);
		}
	}
}
