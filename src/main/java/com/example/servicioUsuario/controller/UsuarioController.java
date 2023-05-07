package com.example.servicioUsuario.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.servicioUsuario.persistence.entity.Usuario;
import com.example.servicioUsuario.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public List<Usuario> obtenerUsuarios() {
		

		
		return this.usuarioService.usuarios();
	}
	
	@GetMapping("/{id}")
	public Usuario obtenerUsuario(@PathVariable("id") Long id) {
		
		
		
		return this.usuarioService.obtenerUsuario(id);
	}

	@PostMapping
	public Usuario crearUsuario(@RequestBody Usuario usuario) {

		
		

		return this.usuarioService.crearUsuario(usuario);
	}
	
	@PutMapping
	public ResponseEntity<Usuario> Usuario(@RequestBody Usuario usuario){
		
		this.usuarioService.actualizarUsuario(usuario);
		
		return ResponseEntity.ok(usuario);
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
