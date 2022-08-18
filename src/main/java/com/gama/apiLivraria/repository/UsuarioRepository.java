package com.gama.apiLivraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gama.apiLivraria.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

	List<Usuario> findByEmail(String email);

}
