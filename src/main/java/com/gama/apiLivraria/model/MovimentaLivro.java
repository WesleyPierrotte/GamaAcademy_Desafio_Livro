package com.gama.apiLivraria.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class MovimentaLivro {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy="movimentaLivro")
    private List<Livro> livros = new ArrayList<>();
	@OneToOne
    private Usuario usuario;
    private LocalDateTime data_retirada = LocalDateTime.now();
    private LocalDateTime data_devolucao = null;
    

	public MovimentaLivro(Long id, List<Livro> livros, Usuario usuario, LocalDateTime data_retirada,
			LocalDateTime data_devolucao) {
		super();
		this.id = id;
		this.livros = livros;
		this.usuario = usuario;
		this.data_retirada = data_retirada;
		this.data_devolucao = data_devolucao;
	}

	public MovimentaLivro() {
		
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<Livro> getLivros() {
		return livros;
	}


	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public LocalDateTime getData_retirada() {
		return data_retirada;
	}


	public void setData_retirada(LocalDateTime data_retirada) {
		this.data_retirada = data_retirada;
	}


	public LocalDateTime getData_devolucao() {
		return data_devolucao;
	}


	public void setData_devolucao(LocalDateTime data_devolucao) {
		this.data_devolucao = data_devolucao;
	}


	@Override
	public String toString() {
		return "MovimentaLivro [id=" + id + ", livros=" + livros + ", usuario=" + usuario + ", data_retirada="
				+ data_retirada + ", data_devolucao=" + data_devolucao + "]";
	}
    
}
