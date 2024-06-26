package com.gestioncolegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestioncolegio.entity.Rol;
import com.gestioncolegio.service.RolService;

@RestController
@RequestMapping("/roles")
public class RolController {

	@Autowired
	RolService rolService;

	@GetMapping("/test")
	public ResponseEntity<String> prueba() {

		return ResponseEntity.ok("Funciona");
	}

	@GetMapping
	public ResponseEntity<?> getRoles() {
		try {
			List<Rol> roles = rolService.listarRoles();
			return ResponseEntity.ok(roles);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al obtener las asignaturas" + e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getRol(int id) {
		try {
			
			Rol rol = rolService.buscarRolId(id);
			return ResponseEntity.ok(rol);

		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al obtener las asignaturas" + e.getMessage());
		}
	}
	
	
	@GetMapping("nombre/{nombre}")	
	public ResponseEntity<?> getRol(String nombre) {
		try {
			
			Rol rol = rolService.buscarRolNombre(nombre);
			return ResponseEntity.ok(rol);
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al obtener las asignaturas" + e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> createRol(@RequestBody Rol rol) {
		try {
			Rol rolNuevo = rolService.guardar(rol);
			return ResponseEntity.ok(rolNuevo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener las asignaturas" +  e.getMessage());
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateRol(@RequestBody Rol rol) {
		try {
			Rol rolActualizado= rolService.guardar(rol);
			return ResponseEntity.ok(rolActualizado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener las asignaturas" +  e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRol(@PathVariable int id){
		try {
			rolService.eliminar(id);
			return ResponseEntity.ok("Asignatura " + id + "eliminada correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener las asignaturas" +  e.getMessage());
		}
		
	}
	
	
	
	
	

}
