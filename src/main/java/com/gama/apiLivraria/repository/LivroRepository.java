package com.gama.apiLivraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gama.apiLivraria.model.Livro;

public interface LivroRepository extends JpaRepository<Livro,Long> {

	List<Livro> findByAutorNome(String autor);

	List<Livro> findByTitulo(String titulo);

}
