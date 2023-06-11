package com.example.servicioUsuario.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.servicioUsuario.persistence.entity.Usuario;
import com.example.servicioUsuario.persistence.entity.UsuarioRol;
import com.example.servicioUsuario.service.dto.UsuarioDto;

@Component
public class UsuarioDtoToUsuario implements IMapper<UsuarioDto, Usuario> {

	@Override
	public Usuario map(UsuarioDto in) {
		Usuario usuario = new Usuario();
		usuario.setNombre(in.getNombre());
		usuario.setApellido(in.getApellido());
		usuario.setDocumento(in.getDocumento());
		usuario.setFechaAlta(LocalDateTime.now());
		usuario.setRol(UsuarioRol.USER);
		usuario.setClave("1234");

		return usuario;
	}

}
