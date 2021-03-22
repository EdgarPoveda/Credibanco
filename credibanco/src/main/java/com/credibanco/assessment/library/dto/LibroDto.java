package com.credibanco.assessment.library.dto;

public class LibroDto {
	private long idLibro;
	private Integer anio;
	private String genero;
	private Integer numeroPaginas;
	private String titulo;
	private String autor;
	private String editorial;
	
	
	
	public LibroDto(long idLibro, Integer anio, String genero, Integer numeroPaginas, String titulo, String autor,
			String editorial) {
		this.idLibro = idLibro;
		this.anio = anio;
		this.genero = genero;
		this.numeroPaginas = numeroPaginas;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
	}
	
	public LibroDto() {
	}

	public long getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	

}
