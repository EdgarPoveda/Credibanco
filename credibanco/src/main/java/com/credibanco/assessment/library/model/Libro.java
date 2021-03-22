package com.credibanco.assessment.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the LIBROS database table.	
 * 
 */
@Entity
@Table(name = "LIBROS")
@NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "LIBROS_IDLIBRO_GENERATOR", sequenceName = "LIBROS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIBROS_IDLIBRO_GENERATOR")
	@Column(name = "ID_LIBRO")
	private long idLibro;
	private Integer anio;
	@NotEmpty
	private String genero;
	@NotNull
	@Column(name = "NUMERO_PAGINAS")
	private Integer numeroPaginas;
	@NotEmpty
	private String titulo;

	//Validacion de validation.constraints
	@NotNull
	// bi-directional many-to-one association to Autor
	@ManyToOne
	@JoinColumn(name = "ID_AUTOR")
	private Autor autor;

	// bi-directional many-to-one association to Editorial
	@ManyToOne
	@JoinColumn(name = "ID_EDITORIAL")
	private Editorial editorial;

	public Libro() {
	}

	public long getIdLibro() {
		return this.idLibro;
	}

	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getNumeroPaginas() {
		return this.numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return this.autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editorial getEditorial() {
		return this.editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

}