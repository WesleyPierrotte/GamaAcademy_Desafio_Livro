package cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gama.apiLivraria.model.Autor;
import com.gama.apiLivraria.model.Livro;
import com.gama.apiLivraria.model.StatusLivro;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManipulandoLivroSteps {
	
	@Autowired
	//private LivroRepository livroRepository;	
	private List<Livro> livros = new ArrayList<Livro>();
	private Livro livro ;
	
	
	@Given("Eu quero consultar um livro por autor")
	public void eu_quero_consultar_um_livro_por_autor() {
		 livro = new Livro(1L,"Orientação a Objeto",new Autor(1L,"Rodrigo Turini"),10,"Casa do Codigo",123,StatusLivro.DISPONIVEL);
		 livros.add(livro);
	}
	@When("Eu digito o nome")
	public void eu_digito_o_nome() {
		//String autor = "Rodrigo Turini";
		//livros = livroRepository.findByAutorNome(autor);
	}
	@Then("Eu obtenho o resultado")
	public void eu_obtenho_o_resultado() {
		//var atual = livros.toString();
		
		//String esperado = "[id=1, titulo=Orientação a Objeto, Autor=Rodrigo Turini, "
		//+ "edicao=10, editora=Casa do Codigo, isbn=123, status=DISPONIVEL]";
		
		var autor = livro.getAutor();
		var atual = livro.exibirLivroPorAutor(autor);
				
		String esperado = "Orientação a Objeto / Rodrigo Turini /"
				+ " 10 / Casa do Codigo / 123 / DISPONIVEL";
		
		assertThat(atual).isEqualTo(esperado);	
	}
}
