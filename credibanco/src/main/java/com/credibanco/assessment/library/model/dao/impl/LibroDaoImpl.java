package com.credibanco.assessment.library.model.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.library.model.Libro;
import com.credibanco.assessment.library.model.dao.ILibroDao;
import com.credibanco.assessment.library.model.dao.ILibroJpa;

@Repository
public class LibroDaoImpl implements ILibroDao {
	@Autowired
	private ILibroJpa libroJpa;

	@Override
	public List<Libro> getLibros() {
		List<Libro> libros= libroJpa.findAll();
		return libros;
	}

	@Override
	public Libro getLibroById(Long id) {
		// TODO Auto-generated method stub
		return libroJpa.findById(id).orElse(null);
	}

	@Override
	public Libro createLibro(Libro libro) {
		Libro ibro = new Libro();
		return libroJpa.save(libro);
	}

	

}
