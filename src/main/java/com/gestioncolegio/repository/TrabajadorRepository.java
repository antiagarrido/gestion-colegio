package com.gestioncolegio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestioncolegio.entity.Rol;
import com.gestioncolegio.entity.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {

	Trabajador findById(int id);

	List<Trabajador> findByRol(Rol rol);

	int countByRol(Rol rol);

}
