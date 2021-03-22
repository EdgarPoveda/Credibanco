package com.credibanco.assessment.library.model.dao;

import java.util.List;

import com.credibanco.assessment.library.model.Editorial;

public interface IEditorialDao {
	public List<Editorial> getEditoriales();
	public Editorial getEditorialById(Long id);
	public Editorial createEditorial(Editorial editorial);
	public Editorial updateEditorial(Long id, Editorial editorial);
	public void deleteEditorial(Long id);

}
