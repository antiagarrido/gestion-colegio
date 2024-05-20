package com.gestioncolegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestioncolegio.entity.Rol;
import com.gestioncolegio.repository.RolRepository;


@Service
public class RolService {
	
	@Autowired
	private RolRepository rolRepository;
	
	public List<Rol> listarRoles(){
		return rolRepository.findAll();
	}
	
	public Rol buscarRolId(int id) {
		return rolRepository.findById(id);
	}
	
	public Rol buscarRolNombre(String nombre) {
		return rolRepository.findByNombre(nombre);
	}
	
	public Rol guardar(Rol rol) {
		return rolRepository.save(rol);
	}
	
	public void eliminar(int id) {
		rolRepository.deleteById(id);
	}
	

}
