package com.gestioncolegio.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gestioncolegio.entity.Trabajador;
import com.gestioncolegio.service.TrabajadorService;

@RestController
@RequestMapping("/trabajadores")
public class TrabajadorController {

	@Autowired
	private TrabajadorService trabajadorService;

	@GetMapping("/test")
	public String prueba() {
		return "Funciona";
	}

	@GetMapping()
	public String obtenerTrabajadores() {
		try {
			
			List<Trabajador> trabajadores = trabajadorService.listarTrabajadores();
			return "buscando todos los trabajadores: \n" + trabajadores;
		} catch (Exception e) {
			return "Error " + e.getMessage();
		}
	}
		

	@GetMapping("/director")
	public String  obtenerDirector() {
		
		return "El director es  "  + trabajadorService.buscarDirector();

	}
	
	@GetMapping("/bedeles")
	public String obtenerBedeles() {
		return "Los bedeles son" + trabajadorService.buscarBedeles();
	}
	
	@GetMapping("/profesores")
	public String obtenerProfesores() {
		return "Los profesores son" + trabajadorService.buscarProfesores();
	}
	

	@GetMapping("/{id}")
	public String getTrabajador(@PathVariable int id) {

		try {
			Trabajador alumno = trabajadorService.buscarTrabajadorId(id);
			return "" + alumno;
		} catch (Exception e) {
			return "No hemos podido encontrar el trabajador" + e.getMessage();
		}
	}

	@PutMapping("/nuevo")
	public String nuevoTrabajador(@RequestBody Trabajador trabajador) {
		try {
			trabajadorService.guardar(trabajador);
			return "Nuevo trabajador: " + trabajador;

		} catch (Exception e) {
			return "No se ha podido añadir el trabajador" + e.getMessage();
		}
	}

	@PutMapping("/actualizar")
	public String actualizarTrabajador(@RequestBody Trabajador trabajador) {
		try {
			trabajadorService.guardar(trabajador);
			return "Trabajador actualizado: " + trabajador;

		} catch (Exception e) {
			return "No se ha podido añadir el trabajador" + e.getMessage();
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public String eliminarTrabajador(@PathVariable int id) {
		try {
			trabajadorService.eliminar(id);
			return "Trabajador eliminado";
		} catch (Exception e) {
			return "no se ha podido eliminar" + e.getMessage();
		}
	}

}
