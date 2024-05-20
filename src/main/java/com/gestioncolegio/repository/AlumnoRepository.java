package com.gestioncolegio.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestioncolegio.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

	List<Alumno> findByNombre(String nombre);
	Alumno findById(int id);
		
	 
	 

}
