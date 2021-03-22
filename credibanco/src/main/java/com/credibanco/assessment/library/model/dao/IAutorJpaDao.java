package com.credibanco.assessment.library.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credibanco.assessment.library.model.Autor;

public interface IAutorJpaDao extends JpaRepository<Autor, Long>  {

}
