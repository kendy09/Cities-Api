package br.com.digitalinovation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digitalinovation.model.State;

public interface StateRepository extends JpaRepository<State, Long> {

}
