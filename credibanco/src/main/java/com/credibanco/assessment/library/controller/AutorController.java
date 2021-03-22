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

import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.service.IAutorService;

@RestController
public class AutorController {
	@Autowired
	private IAutorService autorService;

	@GetMapping(value = "/autores", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Autor> getAutores() {
		return autorService.getAutores();
	}

	@GetMapping(value = "/autores/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Autor getAutorById(@PathVariable Long id) {
		return autorService.getAutorById(id);
	}

	@PostMapping(value = "/createAutor", produces = MediaType.APPLICATION_JSON_VALUE)
	public Autor createAutor(@Valid @RequestBody Autor autor, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "el campo: ' " + err.getField() + " ' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			for (String error : errors) {
				System.out.println(error);
			}
		}
		return autorService.createAutor(autor);

	}

	@PutMapping(value = "/updateAutor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Autor updateAutor(@PathVariable Long id,@RequestBody Autor autor) {
		return autorService.updateAutor(id, autor);
	}
	
	@DeleteMapping(value = "/deleteAutor/{id}")
	public void deleteAutor(@PathVariable Long id) {		
		autorService.deleteAutor(id);
	}

}
