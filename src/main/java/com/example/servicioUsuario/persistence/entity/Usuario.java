package com.example.servicioUsuario.persistence.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "usuario", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Usuario {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "documento")
	private String documento;
	@Column(name = "fechaAlta")
	private LocalDateTime fechaAlta;
	@Column(name = "clave")
	private String clave;
	@Column(name = "rol")
	private UsuarioRol rol;
	@OneToMany(mappedBy="rol", cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Usuario> roles=new HashSet<>();

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public UsuarioRol getRol() {
		return rol;
	}

	public void setRol(UsuarioRol rol) {
		this.rol = rol;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

}
