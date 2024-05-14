package com.gestioncolegio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/todos")
	public String obtenerAlumnos() {
		List<Alumno> alumnos = alumnoService.listarAlumnos();
		return "buscando todos los alumnos: \n" + alumnos;

	}

	@GetMapping("/alumno")
	public String getAlumno(@RequestParam("id") String idString) {
		try {
			int id = Integer.parseInt(idString);
			Optional<Alumno> alumno = alumnoService.buscarAlumnoId(id);
			if (alumno.isEmpty()) {

				throw new Exception(" El alumno no existe");
			}
			return "" + alumno;
		} catch (Exception e) {
			return "No hemos podido encontrar el alumno" + e.getMessage();
		}
	}

	@PostMapping("/nuevo")
	public String nuevoAlumno(@RequestBody Alumno alumno) {
		try {
			alumnoService.guardar(alumno);
			return "Nuevo alumno: " + alumno;

		} catch (Exception e) {
			return "No se ha podido añadir el alumno" + e.getMessage();
		}
	}

	@PostMapping("/actualizar")
	public String actualizarAlumno(@RequestBody Alumno alumno) {
		try {
			alumnoService.guardar(alumno);
			return "Alumno actualizado: " + alumno;

		} catch (Exception e) {
			return "No se ha podido añadir el alumno" + e.getMessage();
		}
	}

	@GetMapping("/eliminar")
	public String eliminarAlumno(@RequestParam("id") String idString) {
		try {
			int id = Integer.parseInt(idString);
			alumnoService.eliminar(id);
			return "Alumno eliminado";
		} catch (Exception e) {
			return "no se ha podido eliminar" + e.getMessage();
		}
	}

}
