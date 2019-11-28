package com.libreriapropia.libros.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.libreriapropia.libros.model.Libro;

public interface LibroRepository extends MongoRepository<Libro, Integer>{

}
