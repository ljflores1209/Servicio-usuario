package com.example.servicioUsuario.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.servicioUsuario.persistence.entity.Usuario;
import com.example.servicioUsuario.service.UsuarioService;

import com.example.servicioUsuario.service.dto.UsuarioDto;
import com.example.servicioUsuario.service.dto.UsuarioRespuesta;
import com.example.servicioUsuario.util.AppConstantes;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/obtener_usuarios", method = RequestMethod.GET)
	// @GetMapping("/usuarios")
	public UsuarioRespuesta obtenerUsuarios(
			@RequestParam(value = "pageNo", defaultValue = AppConstantes.NUMERO_DE_PAGINA_POR_DEFECTO, required = false) int numeroDePagina,
			@RequestParam(value = "pageSize", defaultValue = AppConstantes.MEDIDA_DE_PAGINA_POR_DEFECTO, required = false) int medidaDePagina,
			@RequestParam(value = "sortBy", defaultValue = AppConstantes.ORDENAR_POR_DEFECTO, required = false) String ordenarPor,
			@RequestParam(value = "sortDir", defaultValue = AppConstantes.ORDENAR_DIRECCION_POR_DEFECTO, required = false) String sortDir){

		return this.usuarioService.obtenerUsuarios(numeroDePagina,medidaDePagina,ordenarPor,sortDir );
	}

	@GetMapping("/{id}")
	public Usuario obtenerUsuario(@PathVariable("id") Long id) {

		return this.usuarioService.obtenerUsuario(id);
	}

	@PostMapping
	public Usuario crearUsuario(@RequestBody UsuarioDto usuarioDto) {

		return this.usuarioService.crearUsuario(usuarioDto);
	}

	@PutMapping("/editar_usuario")
	public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario) {

		this.usuarioService.actualizarUsuario(usuario);

		return ResponseEntity.ok(usuario);
	}

	@DeleteMapping("/eliminar_usuario/{id}")
	public ResponseEntity<Void> eliminarUsuario(@PathVariable("id") Long id) {

		this.usuarioService.eliminaUsuario(id);

		return ResponseEntity.noContent().build();
	}

}
