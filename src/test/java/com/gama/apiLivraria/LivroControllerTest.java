package com.gama.apiLivraria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gama.apiLivraria.model.Autor;
import com.gama.apiLivraria.model.Livro;
import com.gama.apiLivraria.model.StatusLivro;
import com.gama.apiLivraria.model.Usuario;
import com.gama.apiLivraria.repository.LivroRepository;

@SpringBootTest
public class LivroControllerTest {
	
	@Autowired
	private LivroRepository livroRepository;

	@Test
	void buscaLivroPorAutor() throws JSONException {
		// Arrange
		String autor = "Rodrigo Turini";
		
		// Act
		List<Livro> livros = livroRepository.findByAutorNome(autor);
		var atual = livros.toString();
		String esperado = "[id=1, titulo=Orientação a Objeto, autor=Autor Rodrigo Turini, "
				+ "edicao=10, editora=Casa do Codigo, isbn=123, status=DISPONIVEL]";
		
		//JSONObject my_obj = new JSONObject();
		//my_obj.put("id=", "1");
		//my_obj.put("titulo=", "Orientação a Objeto");
		//my_obj.put("autor=", "Autor Machado de Assis");
		//my_obj.put("edicao=", 10);
		//my_obj.put("editora=", "Casa do Codigo");
		//my_obj.put("isbn=", 1234);
		//my_obj.put("status=", "DISPONIVEL");
		
		//String esperado = my_obj.toString();
		//assertSame(atual,esperado);
		
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
		String esperado = "[id=2, titulo=TDD, autor=Autor Mauricio Aniche, "
				+ "edicao=11, editora=Casa do Codigo, isbn=123, status=VENDIDO]";	
		
		// Assert		
		assertThat(atual).isEqualTo(esperado);		
	}

}
