package com.credibanco.assessment.library.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class EditorialDto  implements Serializable{
	private static final long serialVersionUID = 1L;

	private long idEditorial;
	private String correoElectronico;
	private String direccionCorrespondencia;
	private BigDecimal maximoLibrosRegistrados;
	private String nombre;
	private BigDecimal telefono;
	
	
	public EditorialDto(String correoElectronico, String direccionCorrespondencia,
			BigDecimal maximoLibrosRegistrados, String nombre, BigDecimal telefono) {
		this.correoElectronico = correoElectronico;
		this.direccionCorrespondencia = direccionCorrespondencia;
		this.maximoLibrosRegistrados = maximoLibrosRegistrados;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public long getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(long idEditorial) {
		this.idEditorial = idEditorial;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getDireccionCorrespondencia() {
		return direccionCorrespondencia;
	}
	public void setDireccionCorrespondencia(String direccionCorrespondencia) {
		this.direccionCorrespondencia = direccionCorrespondencia;
	}
	public BigDecimal getMaximoLibrosRegistrados() {
		return maximoLibrosRegistrados;
	}
	public void setMaximoLibrosRegistrados(BigDecimal maximoLibrosRegistrados) {
		this.maximoLibrosRegistrados = maximoLibrosRegistrados;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getTelefono() {
		return telefono;
	}
	public void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
	}
	
	

}
