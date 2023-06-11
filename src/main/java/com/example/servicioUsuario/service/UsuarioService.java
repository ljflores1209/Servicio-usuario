package com.example.servicioUsuario.service;

import org.springframework.http.ResponseEntity;

import com.example.servicioUsuario.persistence.entity.Usuario;
import com.example.servicioUsuario.service.dto.UsuarioDto;
import com.example.servicioUsuario.service.dto.UsuarioRespuesta;

public interface UsuarioService {

	public Usuario crearUsuario(UsuarioDto usuarioDto);

	public UsuarioRespuesta obtenerUsuarios(int numeroDePagina, int medidaDePAgina, String ordenarPor, String sortDir);

	public Usuario obtenerUsuario(Long id);

	public ResponseEntity<Usuario> actualizarUsuario(Usuario usuario);

	public void eliminaUsuario(Long id);

}
