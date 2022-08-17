package com.gama.apiLivraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.apiLivraria.controller.dto.LivroDto;
import com.gama.apiLivraria.model.Autor;
import com.gama.apiLivraria.model.Livro;
import com.gama.apiLivraria.model.StatusLivro;
import com.gama.apiLivraria.model.Usuario;
import com.gama.apiLivraria.repository.LivroRepository;

@RestController
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@RequestMapping("/livros")
	public List<LivroDto> listaLivro(){
		List<Livro> livros = livroRepository.findAll();
		return LivroDto.converter(livros);
		
	}
	
	@GetMapping("/livroAutor")
	public List<LivroDto> consultaLivroAutor(String autor) {
		List<Livro> livros = livroRepository.findByAutorNome(autor);
		return LivroDto.converter(livros);
		// uri = http://localhost:8080/livroAutor?autor=Machado+de+Assis
	}
	
	@GetMapping("/livroTitulo")
	public List<LivroDto> consultaLivroTitulo(String titulo) {
		List<Livro> livros = livroRepository.findByTitulo(titulo);
		return LivroDto.converter(livros);
		// uri = http://localhost:8080/livroTitulo?titulo=Orientação+a+Objeto
	}	

}
