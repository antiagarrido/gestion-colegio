package com.gestioncolegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gestioncolegio.entity.Director;
import com.gestioncolegio.service.DirectorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/director")
public class DirectorController {
	@Autowired
	private DirectorService directorService;

	@GetMapping()
	public List<Director> listarDirectores() {
		return directorService.listarDirectores();
	}


	@PostMapping("/nuevo")
	public String agregarDirector(@RequestBody Director director) {
		try {
			directorService.guardar(director);
			return "Director guardado: " + director;
		} catch (Exception e) {
			return "Error al guardar director: " + e.getMessage();
		}
	}

	@PostMapping("/actualizar")
	public String actualizarDirector(@RequestBody Director director) {
		try {
			directorService.guardar(director);
			return "Director actualizado: " + director;
		} catch (Exception e) {
			return "Error al actualizar director: " + e.getMessage();
		}
	}

	@GetMapping("/eliminar")
	public String eliminarDirector(@RequestParam("id") String idString) {
		try {
			int id = Integer.parseInt(idString);
			directorService.eliminar(id);
			return "Director eliminado";
		} catch (Exception e) {
			return "Error al eliminar director: " + e.getMessage();
		}
	}
}
