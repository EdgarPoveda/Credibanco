package com.credibanco.assessment.library.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credibanco.assessment.library.model.Libro;

public interface ILibroJpa extends JpaRepository<Libro, Long> {

}
