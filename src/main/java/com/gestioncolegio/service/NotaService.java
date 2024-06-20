package com.gestioncolegio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestioncolegio.entity.Nota;
import com.gestioncolegio.entity.NotaId;
import com.gestioncolegio.repository.NotaRepository;

@Service
public class NotaService {

	@Autowired
	private NotaRepository notaRepository;
	
	  public List<Nota> getAllNotas() {
	        return notaRepository.findAll();
	    }

	public Optional<Nota> getNotaById(NotaId id) {
		return notaRepository.findById(id);
	}

	public Nota saveNota(Nota nota) {
		return notaRepository.save(nota);
	}

	public void deleteNota(NotaId id) {
		notaRepository.deleteById(id);
	}

	// Buscar notas por alumnoId
	public List<Nota> getNotasByAlumnoId(int alumnoId) {
		return notaRepository.findByAlumnoId(alumnoId);
	}

	// Buscar notas por asignaturaId
	public List<Nota> getNotasByAsignaturaId(int asignaturaId) {
		return notaRepository.findByAsignaturaId(asignaturaId);
	}

}
