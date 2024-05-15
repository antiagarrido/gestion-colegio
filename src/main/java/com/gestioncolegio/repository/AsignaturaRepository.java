package com.gestioncolegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestioncolegio.entity.Asignatura;


public interface  AsignaturaRepository extends JpaRepository<Asignatura, Integer>{

	Asignatura findByNombre(String nombre);
	Asignatura findById(int id);

}
