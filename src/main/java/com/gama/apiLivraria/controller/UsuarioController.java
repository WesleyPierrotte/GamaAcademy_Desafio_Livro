package com.gama.apiLivraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.apiLivraria.controller.dto.UsuarioDto;
import com.gama.apiLivraria.model.Usuario;
import com.gama.apiLivraria.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping("/usuarios")
	public List<UsuarioDto> listaUsuario(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		return UsuarioDto.converter(usuarios);
		
	}
	
	@RequestMapping("/usuariosEmail")
	public List<UsuarioDto> consultaUsuarioPorEmail(String email){
		List<Usuario> usuarios = usuarioRepository.findByEmail(email);
		return UsuarioDto.converter(usuarios);
		
	}

}
