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
	
	@Autowired
	private LivroRepository livroRepository;

	@Test
	void buscaLivroPorAutor() throws JSONException {
		// Arrange
		String autor = "Machado de Assis";
		
		// Act
		List<Livro> livros = livroRepository.findByAutorNome(autor);
		var atual = livros.toString();
		String esperado = "[id=1, titulo=Orientação a Objeto, autor=Autor Machado de Assis, "
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
	void exibirLivroMetodoClasseLivro() throws JSONException {
		// Arrange
		Livro livro = new Livro(1L,"Orientação a Objeto", new Autor(1L,"Pedro"), 
				new Usuario(1L,"Fulano","fulano@test.com","1234"), 1, "Casa do Codigo", 123, StatusLivro.DISPONIVEL);
		
		// Act
		var atual = livro.exibirLivro();
		String esperado = "Orientação a Objeto / Autor Pedro / 1 / Casa do Codigo / 123 / DISPONIVEL";
		
		// Assert		
		assertThat(atual).isEqualTo(esperado);		
	}

}
