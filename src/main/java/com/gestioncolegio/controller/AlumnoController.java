package com.gestioncolegio.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gestioncolegio.entity.Alumno;
import com.gestioncolegio.service.AlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping("/test")
	public String prueba() {
		return "Funciona";
	}

	@GetMapping()
	public String obtenerAlumnos() {
		List<Alumno> alumnos = alumnoService.listarAlumnos();
		return "buscando todos los alumnos: \n" + alumnos;

	}

	@GetMapping("/{id}")
	public String getAlumno(@PathVariable int id) {

		try {
			Alumno alumno = alumnoService.buscarAlumnoId(id);
			return "" + alumno;
		} catch (Exception e) {
			return "No hemos podido encontrar el alumno" + e.getMessage();
		}
	}

	@PutMapping("/nuevo")
	public String nuevoAlumno(@RequestBody Alumno alumno) {
		try {
			alumnoService.guardar(alumno);
			return "Nuevo alumno: " + alumno;

		} catch (Exception e) {
			return "No se ha podido añadir el alumno" + e.getMessage();
		}
	}

	@PutMapping("/actualizar")
	public String actualizarAlumno(@RequestBody Alumno alumno) {
		try {
			alumnoService.guardar(alumno);
			return "Alumno actualizado: " + alumno;

		} catch (Exception e) {
			return "No se ha podido añadir el alumno" + e.getMessage();
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public String eliminarAlumno(@PathVariable int id) {
		try {
		
			alumnoService.eliminar(id);
			return "Alumno eliminado";
		} catch (Exception e) {
			return "no se ha podido eliminar" + e.getMessage();
		}
	}

}
