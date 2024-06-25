package com.gestioncolegio.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.gestioncolegio.entity.Nota;
import com.gestioncolegio.entity.NotaId;

public interface NotaRepository extends JpaRepository<Nota, NotaId> {

	@Query("SELECT n FROM Nota n WHERE n.id.alumno_id = :alumnoId")
    List<Nota> findByAlumnoId(@Param("alumnoId") int alumnoId);
	
    @Query("SELECT n FROM Nota n WHERE n.id.asignatura_id = :asignaturaId")
    List<Nota> findByAsignaturaId(@Param("asignaturaId") int asignaturaId);


	

	
}
