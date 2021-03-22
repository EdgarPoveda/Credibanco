package com.credibanco.assessment.library.model.dao;

import java.util.List;

import com.credibanco.assessment.library.model.Libro;

public interface ILibroDao {
	public List<Libro> getLibros();
	public Libro getLibroById(Long id);
	public Libro createLibro(Libro libro);

}
