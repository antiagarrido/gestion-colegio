package com.gestioncolegio.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<?> getTrabajadores() {

		try {
			List<Trabajador> trabajadores = trabajadorService.listarTrabajadores();
			return ResponseEntity.ok(trabajadores);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener trabajadores." +  e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getTrabajador(@PathVariable int id) {
		try {
			Trabajador trabajador = trabajadorService.buscarTrabajadorId(id);

			return ResponseEntity.ok( trabajador);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener el trabajador. " +  e.getMessage());
		}
	}

	@GetMapping("/director")
	public ResponseEntity<?> getDirector() {
		try {
			Trabajador director = trabajadorService.buscarDirector();

			return ResponseEntity.ok(director);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}
	}

	@GetMapping("/bedeles")
	public ResponseEntity<?> getBedeles() {
		try {
			List<Trabajador> bedeles = trabajadorService.buscarBedeles();

			return ResponseEntity.ok(bedeles);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener bedeles." +  e.getMessage());
		}

	}

	@GetMapping("/profesores")
	public ResponseEntity<?> getProfesores() {
		try {
			List<Trabajador> profesores = trabajadorService.buscarProfesores();

			return ResponseEntity.ok(profesores);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener profesores." +  e.getMessage());
		}
	}



	@PostMapping
	public ResponseEntity<?> nuevoTrabajador(@RequestBody Trabajador trabajador) {
		try {
			
			Trabajador trabajadorNuevo= trabajadorService.guardar(trabajador);

			return ResponseEntity.ok(trabajadorNuevo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear trabajador" +  e.getMessage());
		}
	}

	@PutMapping()
	public ResponseEntity<?> updateTrabajador( @RequestBody Trabajador trabajador) {
		try {
	
			return ResponseEntity.ok(trabajadorService.guardar(trabajador));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar trabajador" +  e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String > deleteTrabajador(@PathVariable int id) {
		try {
			trabajadorService.eliminar(id);

			return ResponseEntity.ok("Trabajador " + id + " eliminado correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar trabajador" +  e.getMessage());
		}
	}
	
	
	// Asgnaturas 
	
	@GetMapping("/{trabajadorId}/asignaturas")
	public ResponseEntity<?> consultarAsignaturas(@PathVariable int trabajadorId) {
		try {
			List<Asignatura> asignaturas = trabajadorService.consultarAsignaturas(trabajadorId);

			return ResponseEntity.ok(asignaturas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener asignaturas. " + e.getMessage());
		}
	}

	@PostMapping("/asignaturas")
	public ResponseEntity<?> agregarAsignatura(@RequestBody Map <String, Integer> mapaTrabAsig) {
		try {
			int trabajador_id = mapaTrabAsig.get("trabajador_id");
			int asignatura_id = mapaTrabAsig.get("asignatura_id");
			
			Trabajador trabajador = trabajadorService.agregarAsignatura(trabajador_id, asignatura_id);

			return ResponseEntity.ok(trabajador);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al añadir asignaturas. " + e.getMessage());
		}
	}

	@DeleteMapping("/asignaturas")
	public ResponseEntity<?> eliminarAsignatura(@RequestBody Map <String, Integer> mapaTrabAsig) {
		try {
			
			int trabajador_id = mapaTrabAsig.get("trabajador_id");
			int asignatura_id = mapaTrabAsig.get("asignatura_id");
			
			Trabajador trabajador = trabajadorService.eliminarAsignatura(trabajador_id, asignatura_id);

			return ResponseEntity.ok(trabajador);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar asignaturas. " + e.getMessage());
		}
	}


}
