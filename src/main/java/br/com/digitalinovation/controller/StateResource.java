package br.com.digitalinovation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalinovation.model.State;
import br.com.digitalinovation.repository.StateRepository;

@RestController
@RequestMapping("/states")
public class StateResource {
	
	@Autowired
	private StateRepository staterepository;
	
	@GetMapping
	public Page<State>get(Pageable page){
		return staterepository.findAll(page);
	}
	@GetMapping("/{id}")
	public ResponseEntity<State>getState(@PathVariable Long id){
		return staterepository.findById(id).
				map(resp ->ResponseEntity.ok(resp)).
				orElse(ResponseEntity.notFound().build());
			
	}
}
