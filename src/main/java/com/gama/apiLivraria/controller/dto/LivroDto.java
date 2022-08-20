package com.gama.apiLivraria.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.gama.apiLivraria.model.Autor;
import com.gama.apiLivraria.model.Livro;
import com.gama.apiLivraria.model.StatusLivro;


public class LivroDto {
	
	
	private Long id;
	private String titulo;
    private Autor autor;
    private int edicao;
    private String editora;
    private int isbn;
    private StatusLivro statusLivro = StatusLivro.DISPONIVEL;
    
    public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.autor = livro.getAutor();
		this.edicao = livro.getEdicao();
		this.editora = livro.getEditora();
		this.isbn = livro.getIsbn();
		this.statusLivro = livro.getStatus();
	}
    
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public Autor getAutor() {
		return autor;
	}
	public int getEdicao() {
		return edicao;
	}
	public String getEditora() {
		return editora;
	}
	public int getIsbn() {
		return isbn;
	}
	public StatusLivro getStatusLivro() {
		return statusLivro;
	}

	public static List<LivroDto> converter(List<Livro> livros) {
		return livros.stream().map(LivroDto::new).collect(Collectors.toList());
	}

}
