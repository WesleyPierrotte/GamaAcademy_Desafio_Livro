package com.gama.apiLivraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gama.apiLivraria.model.Autor;

public interface AutorRepository extends JpaRepository<Autor,Long>{

	Autor findByNome(String nome);

}
