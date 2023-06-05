package com.mmhernandez.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.dojoninjas.models.Dojo;
import com.mmhernandez.dojoninjas.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	DojoRepository dojoRepository;
	
//	create
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
//	get by id
	public Dojo getById(Long id) {
		Optional<Dojo> optDojo = dojoRepository.findById(id);
		if(optDojo.isPresent()) {
			return optDojo.get();
		}
		return null;
	}
	
//	get all
	public List<Dojo> getAll() {
		return dojoRepository.findAll();		
	}
	
//	get all by id
	public List<Dojo> getAllById(Long id) {
		return dojoRepository.findAllById(id);	
	}
	
}
