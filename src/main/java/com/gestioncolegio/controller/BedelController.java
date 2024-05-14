package com.gestioncolegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gestioncolegio.entity.Bedel;
import com.gestioncolegio.service.BedelService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bedeles")
public class BedelController {
	
	@Autowired
	private BedelService bedelService;

	@GetMapping("/todos")
	public List<Bedel> listarBedeles() {
		return bedelService.listarBedeles();
	}

	@GetMapping("/bedel")
	public String obtenerBedel(@RequestParam("id") String idString) {
		try {
			int id = Integer.parseInt(idString);
			Optional<Bedel> bedel = bedelService.buscarBedelId(id);
			if (bedel.isEmpty()) {
				throw new Exception("El bedel no existe");
			}
			return "Bedel encontrado: " + bedel.get();
		} catch (Exception e) {
			return "Error al buscar bedel: " + e.getMessage();
		}
	}

	@PostMapping("/nuevo")
	public String agregarBedel(@RequestBody Bedel bedel) {
		try {
			bedelService.guardar(bedel);
			return "Bedel guardado: " + bedel;
		} catch (Exception e) {
			return "Error al guardar bedel: " + e.getMessage();
		}
	}

	@PostMapping("/actualizar")
	public String actualizarBedel(@RequestBody Bedel bedel) {
		try {
			bedelService.guardar(bedel);
			return "Bedel actualizado: " + bedel;
		} catch (Exception e) {
			return "Error al actualizar bedel: " + e.getMessage();
		}
	}

	@GetMapping("/eliminar")
	public String eliminarBedel(@RequestParam("id") String idString) {
		try {
			int id = Integer.parseInt(idString);
			bedelService.eliminar(id);
			return "Bedel eliminado";
		} catch (Exception e) {
			return "Error al eliminar bedel: " + e.getMessage();
		}
	}
}
