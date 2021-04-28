package com.algaworks.algafood.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

  Optional<Cozinha> findByNome(String nome); //metodo listar por nome
  //Optional<Cozinha> findNomeByNome(String nome); //metodo listar por nome
  //List<Cozinha> nome (String nome); metodo listar por nome
  //List<Cozinha> findByNomeContaining(String nome); //verifica se contem o que foi passado 
  // int countByCozinhaId(Long cozinha);// conta o total de cozinhas
  
  
	
}