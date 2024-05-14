
package com.gestioncolegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gestioncolegio.entity.Profesor;
import com.gestioncolegio.service.ProfesorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
	@Autowired
	private ProfesorService profesorService;

	@GetMapping("/todos")
	public List<Profesor> listarProfesores() {
		return profesorService.listarProfesores();
	}

	@GetMapping("/profesor")
	public String obtenerProfesor(@RequestParam("id") String idString) {
		try {
			int id = Integer.parseInt(idString);
			Optional<Profesor> profesor = profesorService.buscarProfesorPorId(id);
			if (profesor.isEmpty()) {
				throw new Exception("El profesor no existe");
			}
			return "Profesor encontrado: " + profesor.get();
		} catch (Exception e) {
			return "Error al buscar profesor: " + e.getMessage();
		}
	}

	@PostMapping("/nuevo")
	public String agregarProfesor(@RequestBody Profesor profesor) {
		try {
			profesorService.guardar(profesor);
			return "Profesor guardado: " + profesor;
		} catch (Exception e) {
			return "Error al guardar profesor: " + e.getMessage();
		}
	}

	@PostMapping("/actualizar")
	public String actualizarProfesor(@RequestBody Profesor profesor) {
		try {
			profesorService.guardar(profesor);
			return "Profesor actualizado: " + profesor;
		} catch (Exception e) {
			return "Error al actualizar profesor: " + e.getMessage();
		}
	}

	@GetMapping("/eliminar")
	public String eliminarProfesor(@RequestParam("id") String idString) {
		try {
			int id = Integer.parseInt(idString);
			profesorService.eliminar(id);
			return "Profesor eliminado";
		} catch (Exception e) {
			return "Error al eliminar profesor: " + e.getMessage();
		}
	}
}
