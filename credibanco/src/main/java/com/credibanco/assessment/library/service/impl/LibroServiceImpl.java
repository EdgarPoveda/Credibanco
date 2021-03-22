package com.credibanco.assessment.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.exceptions.AutorNoRegistradoException;
import com.credibanco.assessment.library.exceptions.EditorialNoRegistradaException;
import com.credibanco.assessment.library.exceptions.MaximoPermitidoException;
import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.model.Libro;
import com.credibanco.assessment.library.model.dao.IAutorDao;
import com.credibanco.assessment.library.model.dao.IEditorialDao;
import com.credibanco.assessment.library.model.dao.ILibroDao;
import com.credibanco.assessment.library.service.ILibroService;

@Service
public class LibroServiceImpl implements ILibroService {
	@Autowired
	private ILibroDao libroDao;
	@Autowired
	private IAutorDao autorDao;
	@Autowired
	private IEditorialDao editorialDao;

	@Override
	public List<Libro> getLibros() {
		// TODO Auto-generated method stub
		return libroDao.getLibros();
	}

	@Override
	public Libro getLibroById(Long id) {
		// TODO Auto-generated method stub
		return libroDao.getLibroById(id);
	}

	@Override
	public Libro createLibro(Libro libro) throws MaximoPermitidoException, AutorNoRegistradoException, EditorialNoRegistradaException {
		boolean maximoPermitido = false;
		Autor autorRegistrado = autorDao.getAutorById(libro.getAutor().getIdAutor());
		if (autorRegistrado == null) {
			throw new AutorNoRegistradoException("El autor no está registrado");
		} else {
			libro.setAutor(autorRegistrado);
		}
		if (libro.getEditorial() != null) {
			Editorial editorialRegistrado = new Editorial();
			editorialRegistrado = editorialDao.getEditorialById(libro.getEditorial().getIdEditorial());
			if (editorialRegistrado == null) {
				throw new EditorialNoRegistradaException("La editorial no está registrada");
			} else {
				libro.setEditorial(editorialRegistrado);
			}

			// validación dedisponibilidad para registro de libro
			maximoPermitido = disponibilidadRegistroLibro(maximoPermitido, libro.getEditorial());
		}
		if (maximoPermitido) {
			libro = libroDao.createLibro(libro);
		} else {
			throw new MaximoPermitidoException("No es posible registrar el libro, se alcanzó el máximo permitido.");
		}

		return libro;
	}

	public boolean disponibilidadRegistroLibro(boolean validacion, Editorial editorialValidacion) {
		if (editorialValidacion.getMaximoLibrosRegistrados() > 0) {
			editorialValidacion.setMaximoLibrosRegistrados(editorialValidacion.getMaximoLibrosRegistrados() - 1);
			return true;
		}

		return false;
	}

}
