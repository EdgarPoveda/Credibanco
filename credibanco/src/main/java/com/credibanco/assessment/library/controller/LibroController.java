package com.credibanco.assessment.library.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.dto.LibroDto;
import com.credibanco.assessment.library.exceptions.AutorNoRegistradoException;
import com.credibanco.assessment.library.exceptions.EditorialNoRegistradaException;
import com.credibanco.assessment.library.exceptions.MaximoPermitidoException;
import com.credibanco.assessment.library.model.Libro;
import com.credibanco.assessment.library.service.ILibroService;

@RestController
@CrossOrigin(origins = "*")
public class LibroController {
	@Autowired
	private ILibroService libroService;

	@GetMapping(value = "/libros", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Libro> obtenerLibros() {
		return libroService.getLibros();
	}

	@GetMapping(value = "/librosFront", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LibroDto> obtenerLibrosFront() {
		List<Libro> librosEntity = new ArrayList<Libro>();
		List<LibroDto> libros = new ArrayList<LibroDto>();
		librosEntity = libroService.getLibros();
		for (Libro libro : librosEntity) {	
			LibroDto libroFront = new LibroDto();
			libroFront.setIdLibro(libro.getIdLibro());
			if (libro.getTitulo() != null) {
				libroFront.setTitulo(libro.getTitulo());
			}
			if (libro.getAnio() != null) {
				libroFront.setAnio(libro.getAnio());
			}
			if (libro.getGenero() != null) {
				libroFront.setGenero(libro.getGenero());
			}
			if (libro.getNumeroPaginas() != null) {
				libroFront.setNumeroPaginas(libro.getNumeroPaginas());
			}
			if (libro.getEditorial() != null) {
				libroFront.setEditorial(libro.getEditorial().getNombre());
			}
			if (libro.getAutor() != null) {
				libroFront.setAutor(libro.getAutor().getNombre());
			}
			libros.add(libroFront);
		}
		return libros;
	}

	@GetMapping(value = "/libros/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Libro obtenerLibroPorId(@PathVariable Long id) {
		return libroService.getLibroById(id);
	}

	@PostMapping(value = "/createLibro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> createLibro(@Valid @RequestBody Libro libro, BindingResult result) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		try {
			if (result.hasErrors()) {
				List<String> errors = result.getFieldErrors().stream()
						.map(err -> "el campo: ' " + err.getField() + " ' " + err.getDefaultMessage())
						.collect(Collectors.toList());
				for (String error : errors) {
					respuesta.put("error", error);
				}
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
			}

			libro = libroService.createLibro(libro);
			respuesta.put(libro.getClass().getSimpleName(), libro);
		} catch (MaximoPermitidoException e) {
			respuesta.put("error", e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		} catch (AutorNoRegistradoException e) {
			respuesta.put("error", e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		} catch (EditorialNoRegistradaException e) {
			respuesta.put("error", e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}

}
