package com.example.servicioUsuario.service.dto;

public class RolDTO {

	private long id;
	private String rol;

	public RolDTO() {
		super();
	}

	public RolDTO(long id, String rol) {
		super();
		this.id = id;
		this.rol = rol;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
