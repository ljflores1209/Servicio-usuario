package com.example.servicioUsuario.service;

import com.example.servicioUsuario.persistence.entity.*;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.servicioUsuario.persistence.repository.UsuarioRepository;
import com.example.servicioUsuario.service.dto.UsuarioDto;
import com.example.servicioUsuario.service.dto.UsuarioRespuesta;
import com.example.servicioUsuario.exceptions.ToDoExceptions;
import com.example.servicioUsuario.mapper.UsuarioDtoToUsuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final UsuarioDtoToUsuario mapper;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioDtoToUsuario mapper) {

		this.usuarioRepository = usuarioRepository;
		this.mapper = mapper;
	}

	public Usuario crearUsuario(UsuarioDto usuarioDto) {
		Usuario usuario=this.mapper.map(usuarioDto);
		return this.usuarioRepository.save(usuario);
	}

	public UsuarioRespuesta obtenerUsuarios(int numeroDePagina, int medidaDePAgina, String ordenaPor, String sortDir) {
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(ordenaPor).ascending():Sort.by(ordenaPor).descending();
		
		Pageable pageable=PageRequest.of(numeroDePagina, medidaDePAgina, sort);
		
		Page<Usuario> usuarios= usuarioRepository.findAll(pageable);
		
		List<Usuario> listaUsuarios=usuarios.getContent();
		
		UsuarioRespuesta usuarioRespuesta=new UsuarioRespuesta();

		usuarioRespuesta.setContenido(listaUsuarios);
		usuarioRespuesta.setNumeroPagina(usuarios.getNumber());
		usuarioRespuesta.setMedidaPagina(usuarios.getSize());
		usuarioRespuesta.setTotalElementos(usuarios.getTotalElements());
		usuarioRespuesta.setTotalPaginas(usuarios.getTotalPages());
		usuarioRespuesta.setUltimaPagina(usuarios.isLast());

		return usuarioRespuesta;
	}

	@Transactional
	public Usuario obtenerUsuario(Long id) {

		Optional<Usuario> optional = this.usuarioRepository.findById(id);
		if (optional.isEmpty()) {

			throw new ToDoExceptions("El usuario buscado, no existe!", HttpStatus.NOT_FOUND);
			// System.out.println("Debemos tratar la exception");

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
			System.out.println("El usuario " + usuario.getNombre() + " con numero: " + usuario.getId());
			usuarioRepository.save(usuarioActualiza);
			return ResponseEntity.ok(usuarioActualiza);
		} else {

			// System.out.println("no hay registro con ese numero(Tratar la exception!!)");
			// return ResponseEntity.notFound().build();
			throw new ToDoExceptions("El usuario a actualizar, no existe!", HttpStatus.NOT_FOUND);

		}

	}

	public void eliminaUsuario(Long id) {

		Optional<Usuario> optional = this.usuarioRepository.findById(id);

		if (optional.isEmpty()) {
			throw new ToDoExceptions("El usuario a eliminar, no existe!", HttpStatus.NOT_FOUND);
			// System.out.println("Tratar exception");
		}
		this.usuarioRepository.deleteById(id);

	}

}
