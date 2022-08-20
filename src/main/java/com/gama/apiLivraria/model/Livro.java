package com.gama.apiLivraria.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Livro {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	@OneToOne 
    private Autor autor;
	@OneToOne
    private Usuario usuario;
    private int edicao;
    private String editora;
    private int isbn;
    @Enumerated(EnumType.STRING)
    private StatusLivro status = StatusLivro.DISPONIVEL;
    @ManyToOne
    private MovimentaLivro movimentaLivro;
    @OneToMany
    private List<Livro> livros;
    
    public Livro(Long id, String titulo, Autor autor, int edicao, String editora, int isbn,
			StatusLivro status) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.edicao = edicao;
		this.editora = editora;
		this.isbn = isbn;
		this.status = status;
	}

   public Livro(Long id, String titulo, Autor autor, Usuario usuario, int edicao, String editora, int isbn,
			StatusLivro status) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.usuario = usuario;
		this.edicao = edicao;
		this.editora = editora;
		this.isbn = isbn;
		this.status = status;
	}
   
   public Livro( String titulo, Autor autor, Usuario usuario, int edicao, String editora, int isbn,
			StatusLivro status) {
		this.titulo = titulo;
		this.autor = autor;
		this.usuario = usuario;
		this.edicao = edicao;
		this.editora = editora;
		this.isbn = isbn;
		this.status = status;
		this.livros = new ArrayList<Livro>();
	}
    
    public Livro(String titulo, Autor autor, int edicao, String editora, int isbn, StatusLivro status) {
    	this.titulo = titulo;
		this.autor = autor;
		this.edicao = edicao;
		this.editora = editora;
		this.isbn = isbn;
		this.status = status;
	}

    public Livro() {
    	
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public StatusLivro getStatus() {
		return status;
	}

	public void setStatus(StatusLivro status) {
		this.status = status;
	}

	public MovimentaLivro getMovimentalivro() {
		return movimentaLivro;
	}

	public void setMovimentalivro(MovimentaLivro movimentaLivro) {
		this.movimentaLivro = movimentaLivro;
	}
    
	public String exibirLivro() {
		return titulo + " / " + autor + " / " + edicao + " / " + editora + " / " + isbn + " / " + status;
	}
	
	public String exibirLivroPorAutor(Autor autor) {
		return titulo + " / " + autor.getNome() + " / " + edicao + " / " + editora + " / " + isbn + " / " + status;
	}

	@Override
	public String toString() {
		return "id=" + id + ", titulo=" + titulo + ", " + autor + ", edicao="
				+ edicao + ", editora=" + editora + ", isbn=" + isbn + ", status=" + status;
	}

	public List<Livro> getLivros() {
		return livros;
	}

}


