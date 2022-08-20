package com.gama.apiLivraria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Autor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;
    @OneToOne
    private Livro livro;
    
    public Autor(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
    public Autor() {
		
	}
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Autor=" + nome;
	}

}
