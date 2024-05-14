package com.gestioncolegio.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestioncolegio.entity.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {


}
