package com.gestioncolegio.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestioncolegio.entity.Rol;


public interface RolRepository extends JpaRepository<Rol, Integer>{
	
	 Rol findById(int id);

	Rol findByNombre(String nombre);

}
