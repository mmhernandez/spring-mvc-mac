package com.mmhernandez.dojoninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.dojoninjas.models.Ninja;
import com.mmhernandez.dojoninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	NinjaRepository ninjaRepository;
	
//	create
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
//	get all by dojo id
	public List<Ninja> getByDojoId(Long dojoId) {
		return ninjaRepository.findByDojoId(dojoId);
	}
}
