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
		
		List<Asignatura> asignaturas = asignaturaRepository.findAll();
		
		return asignaturas;
	}

	public Asignatura buscarAsignaturaId(int id) {
		Asignatura asignatura = asignaturaRepository.findById(id);
		return asignatura;
	}

	public List<Asignatura>  buscarAsignaturaNombre(String nombre) {
		return asignaturaRepository.findByNombre(nombre);
	}

	public Asignatura guardar(Asignatura asignatura) {
		return asignaturaRepository.save(asignatura);
	}

	public void eliminar(int id) {
		asignaturaRepository.deleteById(id);
	}

}
