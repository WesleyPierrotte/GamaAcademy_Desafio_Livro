package com.gama.apiLivraria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gama.apiLivraria.model.Usuario;
import com.gama.apiLivraria.repository.UsuarioRepository;

@SpringBootTest
public class UsuarioControllerTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	void buscaUsuarioPorEmail() throws JSONException {
		// Arrange
		String email = "fulano@test.com";

		// Act
		List<Usuario> usuarios = usuarioRepository.findByEmail(email);
		var atual = usuarios.toString();
		String esperado = "[id=1, nome=Fulano, email=fulano@test.com, "
				+ "telefone=55-xx-xxxxxxxxx, cpf=111111111-11, rg=1010101010, endereco=Av.Sucesso 88- Bairro Vitoria - SP-SP/BR]";
		
		// Assert		
		assertThat(atual).isEqualTo(esperado);		
	}

}
