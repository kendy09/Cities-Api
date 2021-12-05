package br.com.digitalinovation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalinovation.model.Country;
import br.com.digitalinovation.repository.CountryRepository;

@RestController
@RequestMapping("/countries")
public class CountryResource {
	
	@Autowired
	private CountryRepository countryrepository;
	
	@GetMapping
	public Page<Country>countries(Pageable page){
		return countryrepository.findAll(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Country> getCountry(@PathVariable Long id ) {
		return countryrepository.findById(id)
				.map(resp ->ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
