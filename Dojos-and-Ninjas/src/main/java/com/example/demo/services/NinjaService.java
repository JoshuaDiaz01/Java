package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Ninja;
import com.example.demo.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;
	
	// ========== Create / Update ===============

	public Ninja save(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}

	// ========== Read ==========================

	public List<Ninja> getAll() {
		return ninjaRepo.findAll();
	}
	
	// Main written out version of getOne()
//	public Toy getOne(Long id) {
//		Optional<Toy> toy = toyRepo.findById(id);
//		
//		if (toy.isPresent()) {
//			return toy.get();
//		} else {
//			return null;
//		}
//	}
	
	// Shorthand version
	public Ninja getOne(Long id) {
		return ninjaRepo.findById(id).orElse(null);
	}

	// ========== Delete ========================
	
	public void delete(Long id) {
		ninjaRepo.deleteById(id);
	}
}
