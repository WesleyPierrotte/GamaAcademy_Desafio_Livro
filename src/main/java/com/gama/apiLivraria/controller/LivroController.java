package com.gama.apiLivraria.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gama.apiLivraria.controller.dto.LivroDto;
import com.gama.apiLivraria.controller.form.LivroForm;
import com.gama.apiLivraria.model.Autor;
import com.gama.apiLivraria.model.Livro;
import com.gama.apiLivraria.model.StatusLivro;
import com.gama.apiLivraria.model.Usuario;
import com.gama.apiLivraria.repository.AutorRepository;
import com.gama.apiLivraria.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@GetMapping()
	public List<LivroDto> listaLivro(){
		List<Livro> livros = livroRepository.findAll();
		return LivroDto.converter(livros);
		
	}
	
	@GetMapping("/autor")
	public List<LivroDto> consultaLivroAutor(String autor) {
		List<Livro> livros = livroRepository.findByAutorNome(autor);
		return LivroDto.converter(livros);
		// uri = http://localhost:8080/livros/autor?autor=Rodrigo+Turini
	}
	
	@GetMapping("/titulo")
	public List<LivroDto> consultaLivroTitulo(String titulo) {
		List<Livro> livros = livroRepository.findByTitulo(titulo);
		return LivroDto.converter(livros);
		// uri = http://localhost:8080/livros/titulo?titulo=Orientação+a+Objeto
	}
	
	@PostMapping()
	public ResponseEntity<LivroDto> cadastrarLivro(@RequestBody LivroForm livroForm, UriComponentsBuilder uriBuilder) {
		Livro livro = livroForm.converter(autorRepository);
		livroRepository.save(livro);
		
		URI uri = uriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).body(new LivroDto(livro));
	}

}
