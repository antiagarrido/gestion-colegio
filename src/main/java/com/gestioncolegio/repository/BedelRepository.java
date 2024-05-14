package com.gestioncolegio.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestioncolegio.entity.Bedel;

public interface BedelRepository extends JpaRepository<Bedel, Integer> {
}
