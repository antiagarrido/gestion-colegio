package com.gestioncolegio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestioncolegio.entity.Director;
import com.gestioncolegio.repository.DirectorRepository;

@Service
public class DirectorService {
	
	@Autowired
	private DirectorRepository directorRepository;

	public List<Director> listarDirectores() {
		return directorRepository.findAll();
	}

	public Optional<Director> buscarDirectorPorId(int id) {
		return directorRepository.findById(id);
	}

	public void guardar(Director director) {
		directorRepository.save(director);
		
	}

	public void eliminar(int id) {
		directorRepository.deleteById(id);
		
	}

}
