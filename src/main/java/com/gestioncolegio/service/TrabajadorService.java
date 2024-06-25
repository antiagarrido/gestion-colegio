package com.gestioncolegio.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gestioncolegio.entity.Asignatura;
import com.gestioncolegio.entity.Rol;
import com.gestioncolegio.entity.Trabajador;
import com.gestioncolegio.repository.TrabajadorRepository;

@Repository
public class TrabajadorService {

	@Autowired
	private TrabajadorRepository trabajadorRepository;

	@Autowired
	private AsignaturaService asignaturaService;
	
	@Autowired
	private RolService rolService;
	

	public List<Trabajador> listarTrabajadores() {
		return trabajadorRepository.findAll();
	}

	public Trabajador buscarTrabajadorId(int id) {
		return trabajadorRepository.findById(id);
	}

	public Trabajador guardar(Trabajador trabajador) throws Exception {
		
		Rol director = rolService.buscarRolNombre("director");
		if (trabajador.getRol().equals(director) && trabajadorRepository.countByRol(director) > 0) {
			
			throw new Exception("Solo puede haber un director");
		}
		return trabajadorRepository.save(trabajador);
	}

	public void eliminar(int id) {
		trabajadorRepository.deleteById(id);
	}

	public Trabajador buscarDirector() {
		

		List<Trabajador> directores = trabajadorRepository.findByRol(rolService.buscarRolNombre("director"));

		return directores.get(0);
		
	}

	public List<Trabajador> buscarBedeles() {
		Rol bedel = rolService.buscarRolNombre("bedel");
		
		return trabajadorRepository.findByRol(bedel);
	}

	public List<Trabajador> buscarProfesores() {
	
		
		Rol profesor = rolService.buscarRolNombre("profesor");
		return trabajadorRepository.findByRol(profesor);
	}

	public Trabajador agregarAsignatura(int trabajadorId, int asignaturaId) throws Exception {
		
		Trabajador trabajador = buscarTrabajadorId(trabajadorId);
		Asignatura asignatura = asignaturaService.buscarAsignaturaId(asignaturaId);

		if (!trabajador.getRol().getNombre().equalsIgnoreCase("profesor")) {
			
			throw new Exception("Este trabajador no es profesor");
		}

		trabajador.getAsignaturas().add(asignatura);
		return trabajadorRepository.save(trabajador);
	}

	public Trabajador eliminarAsignatura(int trabajadorId, int asignaturaId) {
	
		Trabajador trabajador = buscarTrabajadorId(trabajadorId);
		Asignatura asignatura = asignaturaService.buscarAsignaturaId(asignaturaId);

		trabajador.getAsignaturas().remove(asignatura);
		return trabajadorRepository.save(trabajador);
	}

	public List<Asignatura> consultarAsignaturas(int trabajadorId) {
		
		Trabajador trabajador = buscarTrabajadorId(trabajadorId);
		
		return trabajador.getAsignaturas();
	}
}
