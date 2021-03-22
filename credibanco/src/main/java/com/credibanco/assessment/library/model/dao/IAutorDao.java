package com.credibanco.assessment.library.model.dao;

import java.util.List;

import com.credibanco.assessment.library.model.Autor;

public interface IAutorDao {
	public List<Autor> getAutores();
	public Autor getAutorById(Long id);
	public Autor createAutor(Autor autor);
	public Autor updateAutor(Long id, Autor autor);
	public void deleteAutor(Long id);
}
