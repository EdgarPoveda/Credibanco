package com.credibanco.assessment.library.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the EDITORIALES database table.
 * 
 */
@Entity
@Table(name="EDITORIALES")
@NamedQuery(name="Editorial.findAll", query="SELECT e FROM Editorial e")
public class Editorial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EDITORIALES_IDEDITORIAL_GENERATOR", sequenceName="EDITORIALES_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EDITORIALES_IDEDITORIAL_GENERATOR" )
	@Column(name="ID_EDITORIAL")
	private long idEditorial;
	@Email
	@Column(name="CORREO_ELECTRONICO")
	private String correoElectronico;
	
	@NotEmpty
	@Column(name="DIRECCION_CORRESPONDENCIA")
	private String direccionCorrespondencia;
	@NotNull
	@Column(name="MAXIMO_LIBROS_REGISTRADOS")
	private Integer maximoLibrosRegistrados;
	@NotEmpty
	private String nombre;
	@NotNull
	private BigDecimal telefono;

	//bi-directional many-to-one association to Libro
//	@JsonIgnore
//	@OneToMany(mappedBy="editorial")
//	private List<Libro> libros;

	public Editorial() {
	}

	public long getIdEditorial() {
		return this.idEditorial;
	}

	public void setIdEditorial(long idEditorial) {
		this.idEditorial = idEditorial;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDireccionCorrespondencia() {
		return this.direccionCorrespondencia;
	}

	public void setDireccionCorrespondencia(String direccionCorrespondencia) {
		this.direccionCorrespondencia = direccionCorrespondencia;
	}

	public Integer getMaximoLibrosRegistrados() {
		return maximoLibrosRegistrados;
	}

	public void setMaximoLibrosRegistrados(Integer maximoLibrosRegistrados) {
		this.maximoLibrosRegistrados = maximoLibrosRegistrados;
	}

	public BigDecimal getTelefono() {
		return telefono;
	}

	public void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

//	public List<Libro> getLibros() {
//		return this.libros;
//	}
//
//	public void setLibros(List<Libro> libros) {
//		this.libros = libros;
//	}

//	public Libro addLibro(Libro libro) {
//		getLibros().add(libro);
//		libro.setEditoriale(this);
//
//		return libro;
//	}
//
//	public Libro removeLibro(Libro libro) {
//		getLibros().remove(libro);
//		libro.setEditoriale(null);
//
//		return libro;
//	}

}