package com.credibanco.assessment.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.model.dao.IEditorialDao;
import com.credibanco.assessment.library.service.IEditorialService;
@Service	
public class EditorialServiceImpl implements IEditorialService {
	@Autowired
	private IEditorialDao editorialDao;

	@Override
	public List<Editorial> getEditoriales() {
		// TODO Auto-generated method stub
		return editorialDao.getEditoriales();
	}

	@Override
	public Editorial getEditorialById(Long id) {
		// TODO Auto-generated method stub
		return editorialDao.getEditorialById(id);
	}

	@Override
	public Editorial createEditorial(Editorial editorial) {
		// TODO Auto-generated method stub
		return editorialDao.createEditorial(editorial);
	}

	@Override
	public Editorial updateEditorial(Long id, Editorial editorial) {
		// TODO Auto-generated method stub
		return editorialDao.updateEditorial(id, editorial);
	}

	@Override
	public void deleteEditorial(Long id) {
		// TODO Auto-generated method stub
		editorialDao.deleteEditorial(id);
	}

}
