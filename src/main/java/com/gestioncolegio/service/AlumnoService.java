package com.gestioncolegio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestioncolegio.entity.Alumno;
import com.gestioncolegio.repository.AlumnoRepository;

@Service
public class AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;

   
	public List<Alumno> listarAlumnos(){
		return alumnoRepository.findAll();
	}
	

	public Optional<Alumno> buscarAlumnoId(int id) {
		return alumnoRepository.findById(id);
	}


	public void guardar(Alumno alumno) {
		alumnoRepository.save(alumno);
	}


	public void eliminar(int id) {
		alumnoRepository.deleteById(id);		
	}

	
}
