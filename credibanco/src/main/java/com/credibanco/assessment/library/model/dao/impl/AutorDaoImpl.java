package com.credibanco.assessment.library.model.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.model.dao.IAutorDao;
import com.credibanco.assessment.library.model.dao.IAutorJpaDao;

@Repository
public class AutorDaoImpl implements IAutorDao {
	@Autowired
	private IAutorJpaDao autorJpaDao;

	@Override
	public List<Autor> getAutores() {
		// TODO Auto-generated method stub
		return autorJpaDao.findAll();
	}

	@Override
	public Autor getAutorById(Long id) {
		// TODO Auto-generated method stub
		return autorJpaDao.findById(id).orElse(null);
	}

	@Override
	public Autor createAutor(Autor autor) {
		// TODO Auto-generated method stub
		return autorJpaDao.save(autor);
	}

	@Override
	public Autor updateAutor(Long id, Autor autor) {
		// TODO Auto-generated method stub
		Autor autorActualizado = new Autor();
			autorActualizado = autorJpaDao.findById(id).orElse(null);	
			autorActualizado.setCiudadProcedencia(autor.getCiudadProcedencia());
			autorActualizado.setCorreoElectronico(autor.getCorreoElectronico());
			autorActualizado.setFechaNacimiento(autor.getFechaNacimiento());
			autorActualizado.setNombre(autor.getNombre());
			return autorJpaDao.save(autorActualizado);
		
	}

	@Override
	public void deleteAutor(Long id) {
		if (id != null) {
			autorJpaDao.deleteById(id);
		}
		
		
	}

}
