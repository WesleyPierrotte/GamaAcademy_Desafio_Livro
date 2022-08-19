package com.gama.apiLivraria.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String rg;
    private String endereco;
    @OneToMany
    private List<Usuario> usuarios = new ArrayList<>();
    @ManyToOne
    private MovimentaLivro movimenta;
    
	public Usuario() {
		
	}
	
	public Usuario(Long id, String nome, String email, String telefone, String cpf, String rg, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public MovimentaLivro getMovimenta() {
		return movimenta;
	}


	public void setMovimenta(MovimentaLivro movimenta) {
		this.movimenta = movimenta;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

    public Usuario adicionaUsuario(Usuario usuario) {  	
    	this.usuarios.add(usuario);
    	return this;
    }
    
	@Override
	public String toString() {
		return "id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cpf=" + cpf
				+ ", rg=" + rg + ", endereco=" + endereco;
	}

}
