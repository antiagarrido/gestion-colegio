package com.gestioncolegio.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gestioncolegio.entity.Asignatura;
import com.gestioncolegio.entity.Trabajador;
import com.gestioncolegio.repository.TrabajadorRepository;


@Repository
public class TrabajadorService {

	@Autowired
	private TrabajadorRepository trabajadorRepository;

	@Autowired
	private AsignaturaService asignaturaService;

	public List<Trabajador> listarTrabajadores() {

		return trabajadorRepository.findAll();
	}

	public Trabajador buscarTrabajadorId(int id) {
		return trabajadorRepository.findById(id);
	}

	public void guardar(Trabajador trabajador) throws RuntimeException {

		if (trabajador.getRol().equals("director") && trabajadorRepository.countByRol("director") > 0) {

			throw new RuntimeException("Solo puede haber un director");

		}
		trabajadorRepository.save(trabajador);
	}

	public void eliminar(int id) {
		trabajadorRepository.deleteById(id);
	}

	public List<Trabajador> buscarDirector() {

		return trabajadorRepository.findByRol("director");

	}

	public List<Trabajador> buscarBedeles() {
		return trabajadorRepository.findByRol("bedel");
	}

	public List<Trabajador> buscarProfesores() {
		return trabajadorRepository.findByRol("profesor");
	}

	public Trabajador agregarAsignatura(int trabajador_id, int asignatura_id) {

		Trabajador trabajador = trabajadorRepository.findById(trabajador_id);
		Asignatura asignatura = asignaturaService.buscarAsignaturaId(asignatura_id);

		if (!trabajador.getRol().equals("profesor")) {
			throw new RuntimeException("Este trabajador no es profesor");
		}

		trabajador.getAsignaturas().add(asignatura);
		return trabajadorRepository.save(trabajador);

	}
	public Trabajador eliminarAsignatura(int trabajador_id, int asignatura_id) {
		
		Trabajador trabajador = trabajadorRepository.findById(trabajador_id);
		Asignatura asignatura = asignaturaService.buscarAsignaturaId(asignatura_id);
		
		trabajador.getAsignaturas().remove(asignatura);
		return trabajadorRepository.save(trabajador);
		
	}
	
	

}
