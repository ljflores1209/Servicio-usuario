package com.example.servicioUsuario.service.dto;

import java.util.List;

import com.example.servicioUsuario.persistence.entity.Usuario;

public class UsuarioRespuesta {

	private List<Usuario> contenido;
	private int numeroPagina;
	private int medidaPagina;
	private long totalElementos;
	private int totalPaginas;
	private boolean ultimaPagina;

	public UsuarioRespuesta() {
		super();
	}

	public List<Usuario> getContenido() {
		return contenido;
	}

	public void setContenido(List<Usuario> contenido) {
		this.contenido = contenido;
	}

	public int getNumeroPagina() {
		return numeroPagina;
	}

	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

	public int getMedidaPagina() {
		return medidaPagina;
	}

	public void setMedidaPagina(int medidaPagina) {
		this.medidaPagina = medidaPagina;
	}

	public long getTotalElementos() {
		return totalElementos;
	}

	public void setTotalElementos(long totalElementos) {
		this.totalElementos = totalElementos;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public void setTotalPaginas(int totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	public boolean isUltimaPagina() {
		return ultimaPagina;
	}

	public void setUltimaPagina(boolean ultimaPagina) {
		this.ultimaPagina = ultimaPagina;
	}

}
