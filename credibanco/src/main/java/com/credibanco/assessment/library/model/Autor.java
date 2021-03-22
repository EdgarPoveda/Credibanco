package com.credibanco.assessment.library.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;


/**
 * The persistent class for the AUTORES database table.
 * 
 */
@Entity
@Table(name="AUTORES")
@NamedQuery(name="Autor.findAll", query="SELECT a FROM Autor a")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUTORES_IDAUTOR_GENERATOR", sequenceName="AUTORES_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTORES_IDAUTOR_GENERATOR")
	@Column(name="ID_AUTOR")
	private long idAutor;

	@Column(name="CIUDAD_PROCEDENCIA")
	private String ciudadProcedencia;

	@Column(name="CORREO_ELECTRONICO")
	private String correoElectronico;

	@Column(name="FECHA_NACIMIENTO")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	@NotEmpty
	private String nombre;

	//bi-directional many-to-one association to Libro
//	@JsonIgnore
//	@OneToMany(mappedBy="autor")
//	private List<Libro> libros;

	public Autor() {
	}

	public long getIdAutor() {
		return this.idAutor;
	}

	public void setIdAutor(long idAutor) {
		this.idAutor = idAutor;
	}

	public String getCiudadProcedencia() {
		return this.ciudadProcedencia;
	}

	public void setCiudadProcedencia(String ciudadProcedencia) {
		this.ciudadProcedencia = ciudadProcedencia;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
//		libro.setAutore(this);
//
//		return libro;
//	}
//
//	public Libro removeLibro(Libro libro) {
//		getLibros().remove(libro);
//		libro.setAutore(null);
//
//		return libro;
//	}

}