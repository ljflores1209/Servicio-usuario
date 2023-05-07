package com.example.servicioUsuario.service;

import com.example.servicioUsuario.persistence.entity.*;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.servicioUsuario.persistence.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {

		this.usuarioRepository = usuarioRepository;
	}

	public Usuario crearUsuario(Usuario usuario) {

		usuario.setNombre("Pepe");
		usuario.setApellido("Ruíz");
		usuario.setDocumento("43210");

		return this.usuarioRepository.save(usuario);
	}

	public List<Usuario> usuarios() {

		return this.usuarioRepository.findAll();
	}

	@Transactional
	public Usuario obtenerUsuario(Long id) {

		Optional<Usuario> optional = this.usuarioRepository.findById(id);
		if (optional.isEmpty()) {

			System.out.println("Debemos tratar la exception");

		}

		return this.usuarioRepository.obtenerUsuarioById(id);
	}

	@Transactional
	public ResponseEntity<Usuario> actualizarUsuario(Usuario usuario) {

		Optional<Usuario> optional = this.usuarioRepository.findById(usuario.getId());
		if (optional.isPresent()) {
			Usuario usuarioActualiza = optional.get();
			usuarioActualiza.setNombre(usuario.getNombre());
			usuarioActualiza.setApellido(usuario.getApellido());
			usuarioActualiza.setDocumento(usuario.getDocumento());
			System.out.println("El usuario " + usuario.getNombre() +  " con numero: "+usuario.getId());
			usuarioRepository.save(usuarioActualiza);
			return ResponseEntity.ok(usuarioActualiza);
		} else {
			System.out.println("no hay registro con ese numero(Tratar la exception!!)");
			return ResponseEntity.notFound().build();

		}

	}
	
	public void eliminaUsuario(Long id) {
		
		Optional<Usuario> optional=this.usuarioRepository.findById(id);
		
		if(optional.isEmpty()) {
			System.out.println("Tratar exception");
		}
		this.usuarioRepository.deleteById(id);
		
		
	}

}
