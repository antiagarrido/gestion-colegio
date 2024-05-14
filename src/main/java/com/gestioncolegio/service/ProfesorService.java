package com.gestioncolegio.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestioncolegio.entity.Profesor;
import com.gestioncolegio.repository.ProfesorRepository;

@Service
public class ProfesorService {
	
	@Autowired
	private ProfesorRepository profesorRepository;

	public List<Profesor> listarProfesores() {
		return profesorRepository.findAll();
	}

	public Optional<Profesor> buscarProfesorPorId(int id) {
		return profesorRepository.findById(id);
	}

	public void guardar(Profesor profesor) {
		profesorRepository.save(profesor);
		
	}

	public void eliminar(int id) {
		profesorRepository.deleteById(id);
		
	}

}
