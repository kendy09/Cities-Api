package br.com.digitalinovation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digitalinovation.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
