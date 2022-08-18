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
class ApiApplicationTests {
	
	@Test
	void exibirLivroMetodoClasseLivro() throws JSONException {
		// Arrange
		Livro livro = new Livro(1L,"Orientação a Objeto", new Autor(1L,"Rodrigo Turini"), 
				new Usuario(1L,"Fulano","fulano@test.com","55-xx-xxxxxxxxx","333333333-33","30303030","Beco sem saida-BR"), 1, "Casa do Codigo", 123, StatusLivro.DISPONIVEL);
		
		// Act
		var atual = livro.exibirLivro();
		String esperado = "Orientação a Objeto / Autor Rodrigo Turini / 1 / Casa do Codigo / 123 / DISPONIVEL";
		
		// Assert		
		assertThat(atual).isEqualTo(esperado);		
	}

}
