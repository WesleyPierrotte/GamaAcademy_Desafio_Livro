package com.gama.apiLivraria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gama.apiLivraria.controller.form.LivroForm;
import com.gama.apiLivraria.model.Autor;
import com.gama.apiLivraria.model.Livro;
import com.gama.apiLivraria.model.StatusLivro;
import com.gama.apiLivraria.model.Usuario;
import com.gama.apiLivraria.repository.AutorRepository;
import com.gama.apiLivraria.repository.LivroRepository;

@SpringBootTest
public class LivroControllerTest {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorRepository autorRepository;

	@Test
	void buscaLivroPorAutor() throws JSONException {
		// Arrange
		String autor = "Rodrigo Turini";
		
		// Act
		List<Livro> livros = livroRepository.findByAutorNome(autor);
		var atual = livros.toString();
		String esperado = "[id=1, titulo=Orientação a Objeto, Autor=Rodrigo Turini, "
				+ "edicao=10, editora=Casa do Codigo, isbn=123, status=DISPONIVEL]";
		
		// Assert		
		assertThat(atual).isEqualTo(esperado);		
	}
	
	@Test
	void buscaLivroPorTitulo() throws JSONException {
		// Arrange
		String titulo = "TDD";
		
		// Act
		List<Livro> livros = livroRepository.findByTitulo(titulo);
		var atual = livros.toString();
		String esperado = "[id=2, titulo=TDD, Autor=Mauricio Aniche, "
				+ "edicao=11, editora=Casa do Codigo, isbn=123, status=VENDIDO]";	
		
		// Assert		
		assertThat(atual).isEqualTo(esperado);		
	}
	
	@Test
	void adicionaLivro() throws JSONException {
		// Arrange
		Autor autor = autorRepository.findByNome("Julia Naomi Boeira");
		
		Livro livro = new Livro("TDD para Games",autor, 17, "Casa do Codigo",123,StatusLivro.ATRASADO);
		
		// Act
		livroRepository.save(livro);
		var atual = livro.toString();
		String esperado = "id=3, titulo=TDD para Games, Autor=Julia Naomi Boeira, "
				+ "edicao=17, editora=Casa do Codigo, isbn=123, status=ATRASADO";	
		
		// Assert		
		assertThat(atual).isEqualTo(esperado);		
	}

}
