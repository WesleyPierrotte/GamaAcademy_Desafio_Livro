package com.gama.apiLivraria.controller.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.gama.apiLivraria.model.Usuario;

public class UsuarioDto {
	
	private Long id;
	private String nome;
    private String email;
    private String telefone;
    private String endereco;
    
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.telefone = usuario.getTelefone();
		this.endereco = usuario.getEndereco();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}

}
