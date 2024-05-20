package com.gestioncolegio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestioncolegio.entity.Asignatura;


public interface  AsignaturaRepository extends JpaRepository<Asignatura, Integer>{

	List<Asignatura> findByNombre(String nombre);
	Asignatura findById(int id);

}
