package com.credibanco.assessment.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.model.dao.IAutorDao;
import com.credibanco.assessment.library.service.IAutorService;

@Service
public class AutorServiceImpl implements IAutorService {
	@Autowired
	private IAutorDao autorDao;

	@Override
	public List<Autor> getAutores() {
		// TODO Auto-generated method stub
		return autorDao.getAutores();
	}

	@Override
	public Autor getAutorById(Long id) {
		// TODO Auto-generated method stub
		return autorDao.getAutorById(id);
	}

	@Override
	public Autor createAutor(Autor autor) {
		// TODO Auto-generated method stub
		return autorDao.createAutor(autor) ;
	}

	@Override
	public Autor updateAutor(Long id, Autor autor) {
		// TODO Auto-generated method stub
		return autorDao.updateAutor(id, autor);
	}

	@Override
	public void deleteAutor(Long id) {
		autorDao.deleteAutor(id);
		
	}

}
