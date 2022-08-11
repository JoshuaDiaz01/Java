package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Dojo;
import com.example.demo.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepo;
	
//	create and update
	public Dojo save(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
//	read
	public List<Dojo> getAll(){
		return dojoRepo.findAll();
	}
	
	public Dojo getOne(Long id) {
		Optional<Dojo> optDojo = dojoRepo.findById(id);
		
		if(optDojo.isPresent()) {
			return optDojo.get();
		}else {
			return null;
		}
	}
	
//	delete
	public void delete(Long id) {
		dojoRepo.deleteById(id);
	}
	
	
}
