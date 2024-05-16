package com.gestioncolegio.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestioncolegio.entity.Asignatura;
import com.gestioncolegio.repository.AsignaturaRepository;

@Service
public class AsignaturaService {

	@Autowired
	private AsignaturaRepository asignaturaRepository;

	public List<Asignatura> listarAsignaturas() {
		return asignaturaRepository.findAll();
	}

	public Asignatura buscarAsignaturaId(int id) {
		return asignaturaRepository.findById(id);
	}

	public Asignatura buscarAsignaturaNombre(String nombre) {
		return asignaturaRepository.findByNombre(nombre);
	}

	public void guardar(Asignatura asignatura) {
		asignaturaRepository.save(asignatura);
	}

	public void eliminar(int id) {
		asignaturaRepository.deleteById(id);
	}

}
