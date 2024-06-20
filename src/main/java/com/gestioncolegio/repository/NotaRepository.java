package com.gestioncolegio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestioncolegio.entity.Nota;
import com.gestioncolegio.entity.NotaId;

public interface NotaRepository extends JpaRepository<Nota, NotaId> {

	List<Nota> findByAlumnoId(Integer alumnoId);

	List<Nota> findByAsignaturaId(Integer asignaturaId);
	
	Nota findByNotaId(NotaId notaId);
	

	
}
