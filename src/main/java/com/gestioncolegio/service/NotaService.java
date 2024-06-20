package com.gestioncolegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestioncolegio.entity.Nota;
import com.gestioncolegio.entity.NotaId;
import com.gestioncolegio.repository.NotaRepository;

public class NotaService {

	@Autowired
	private NotaRepository notaRepository;

	public Nota getNotaById(NotaId id) {
		return notaRepository.findByNotaId(id);
	}

	public Nota saveNota(Nota nota) {
		return notaRepository.save(nota);
	}

	public void deleteNota(NotaId id) {
		notaRepository.deleteById(id);
	}

	// Buscar notas por alumnoId
	public List<Nota> getNotasByAlumnoId(Integer alumnoId) {
		return notaRepository.findByAlumnoId(alumnoId);
	}

	// Buscar notas por asignaturaId
	public List<Nota> getNotasByAsignaturaId(Integer asignaturaId) {
		return notaRepository.findByAsignaturaId(asignaturaId);
	}

}
