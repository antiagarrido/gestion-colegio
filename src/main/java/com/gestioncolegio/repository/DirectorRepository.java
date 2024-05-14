package com.gestioncolegio.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestioncolegio.entity.Director;


public interface DirectorRepository extends JpaRepository<Director, Integer> {

}
