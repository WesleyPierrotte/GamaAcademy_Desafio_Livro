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

        	usuario.adicionaUsuario(new Usuario(1L,"Cicrano","cicrano@test.com","55-xx-xxxxxxxxx",
        			"44444444-44","404040","Rua Chaves s/n Bairro Cadeado RJ/RJ-BR"));
            
            String esperado = "[id=1, nome=Cicrano, email=cicrano@test.com, telefone=55-xx-xxxxxxxxx, "
            		+ "cpf=44444444-44, rg=404040, endereco=Rua Chaves s/n Bairro Cadeado RJ/RJ-BR]";
            
            var atual = usuario.getUsuarios().toString();

            assertEquals(esperado, atual);
        }
    }

}
