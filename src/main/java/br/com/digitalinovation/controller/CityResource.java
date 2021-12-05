package br.com.digitalinovation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalinovation.model.City;
import br.com.digitalinovation.repository.CityRepository;

@RestController
@RequestMapping("/cities")
public class CityResource {
	
	@Autowired
	private CityRepository cityrepository;
	
	@GetMapping()
	public Page<City>cities(Pageable page){
		return cityrepository.findAll(page);
	}
	@GetMapping("/{id}")
	public ResponseEntity<City> getCity(@PathVariable Long id ) {
		return cityrepository.findById(id).
				map(resp ->ResponseEntity.ok(resp)).
				orElse(ResponseEntity.notFound().build());
	}
}
