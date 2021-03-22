package com.credibanco.assessment.library.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.service.IEditorialService;

@RestController
public class EditorialController {
	@Autowired
	private IEditorialService editorialService;

	@GetMapping(value = "/editoriales", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Editorial> getEditoriales() {
		return editorialService.getEditoriales();
	}

	@GetMapping(value = "/editoriales/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Editorial getEditorialesById(@PathVariable Long id) {
		return editorialService.getEditorialById(id);
	}

	@PostMapping(value = "createEditorial", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Editorial createEditorial(@Valid @RequestBody Editorial editorial, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "el campo: ' " + err.getField() + " ' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			for (String error : errors) {
				System.out.println(error);
			}
		}
		return editorialService.createEditorial(editorial);
	}
	
	
	@PutMapping(value = "updateEditorial/{id}" , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Editorial updateEditorial(@PathVariable Long id, @RequestBody Editorial editorial) {
		return editorialService.updateEditorial(id, editorial);
	}
	
	@DeleteMapping(value = "deleteEditorial/{id}")
	public void deleteEditorial(@PathVariable Long id) {		
		editorialService.deleteEditorial(id);
	}

}
