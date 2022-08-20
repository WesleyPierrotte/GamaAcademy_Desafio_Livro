package com.gama.apiLivraria.controller.form;

import com.gama.apiLivraria.model.Autor;
import com.gama.apiLivraria.model.Livro;
import com.gama.apiLivraria.model.StatusLivro;
import com.gama.apiLivraria.repository.AutorRepository;

public class LivroForm {
	
	private String titulo;
	private String nomeAutor;
	private int edicao;
	private String editora;
	private int isbn;
	private StatusLivro statusLivro = StatusLivro.DISPONIVEL;
		
	
	public Livro converter(AutorRepository autorRepository) {
		Autor autor = autorRepository.findByNome(nomeAutor);
		return new Livro(titulo,autor,edicao,editora,isbn,statusLivro);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public StatusLivro getStatusLivro() {
		return statusLivro;
	}

	public void setStatusLivro(StatusLivro statusLivro) {
		this.statusLivro = statusLivro;
	}

}
