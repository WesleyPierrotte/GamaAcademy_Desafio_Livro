package com.gama.apiLivraria.cucumber.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.gama.apiLivraria.model.Usuario;

@Nested
@DisplayName("Dado interesse em se acessar a livraria")
public class UsuarioTest {
	
	Usuario usuario = new Usuario();
	
    @Nested
    @DisplayName("Quando inserir os dados para cadastro")
    class cadastroUsuario {

        @Test
        @DisplayName("Entao terei meus daddos no sistema")
        public void deveReceberAcesso() {

            usuario.setNome("Cicrano");
            usuario.setEmail("cicrano@test.com");
            usuario.setTelefone("55-xx-xxxxxxxxx");
            usuario.setCpf("44444444-44");
            usuario.setRg("404040");
            usuario.setEndereco("Rua Chaves s/n Bairro Cadeado RJ/RJ-BR");
            
            String esperado = "Cicrano";
            var atual = usuario.getNome().toString();

            assertEquals(esperado, atual);
        }
    }

}
