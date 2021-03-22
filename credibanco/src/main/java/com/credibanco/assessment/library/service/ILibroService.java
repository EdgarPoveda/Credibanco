package com.credibanco.assessment.library.service;

import java.util.List;

import com.credibanco.assessment.library.exceptions.AutorNoRegistradoException;
import com.credibanco.assessment.library.exceptions.EditorialNoRegistradaException;
import com.credibanco.assessment.library.exceptions.MaximoPermitidoException;
import com.credibanco.assessment.library.model.Libro;

public interface ILibroService {
	public List<Libro> getLibros();
	public Libro getLibroById(Long id);
	public Libro createLibro(Libro libro)throws MaximoPermitidoException, AutorNoRegistradoException, EditorialNoRegistradaException;
}
