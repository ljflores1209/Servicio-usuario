package com.example.servicioUsuario.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.servicioUsuario.persistence.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

	@Query(value="SELECT * FROM USUARIO WHERE ID=:id" , nativeQuery=true)
	Usuario obtenerUsuarioById(Long id);
	
	
	
	

}
