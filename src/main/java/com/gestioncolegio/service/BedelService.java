package com.gestioncolegio.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestioncolegio.entity.Bedel;
import com.gestioncolegio.repository.BedelRepository;

@Service
public class BedelService {
	
	@Autowired
	private BedelRepository bedelRepository;

	public List<Bedel> listarBedeles() {
		return bedelRepository.findAll();
	}

	
	public Optional<Bedel> buscarBedelId(int id) {

		return bedelRepository.findById(id);
	}


	public void guardar(Bedel bedel) {
		bedelRepository.save(bedel);
	}

	public void eliminar(int id) {
		bedelRepository.deleteById(id);
		
	}


}
