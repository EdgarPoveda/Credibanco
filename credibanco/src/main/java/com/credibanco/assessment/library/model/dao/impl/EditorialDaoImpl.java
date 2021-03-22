package com.credibanco.assessment.library.model.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.model.dao.IEditorialDao;
import com.credibanco.assessment.library.model.dao.IEditorialJpa;

@Repository
public class EditorialDaoImpl  implements IEditorialDao{
	@Autowired
	private IEditorialJpa editorialJpa;

	@Override
	public List<Editorial> getEditoriales() {
		// TODO Auto-generated method stub
		return editorialJpa.findAll();
	}

	@Override
	public Editorial getEditorialById(Long id) {
		// TODO Auto-generated method stub
		return editorialJpa.findById(id).orElse(null);
	}

	@Override
	public Editorial createEditorial(Editorial editorial) {
		// TODO Auto-generated method stub
		return editorialJpa.save(editorial);
	}

	@Override
	public Editorial updateEditorial(Long id, Editorial editorial) {
		Editorial editorialActualizada = new Editorial();
		editorialActualizada = editorialJpa.findById(id).orElse(null);
		editorialActualizada.setCorreoElectronico(editorial.getCorreoElectronico());
		editorialActualizada.setDireccionCorrespondencia(editorial.getDireccionCorrespondencia());
		editorialActualizada.setNombre(editorial.getNombre());
		editorialActualizada.setTelefono(editorial.getTelefono());
		editorialActualizada.setMaximoLibrosRegistrados(editorial.getMaximoLibrosRegistrados());
		editorialJpa.save(editorialActualizada);
		return editorialActualizada;
	}

	@Override
	public void deleteEditorial(Long id) {
		if (id != null) {
			editorialJpa.deleteById(id);
		}
		
		
	}

}
