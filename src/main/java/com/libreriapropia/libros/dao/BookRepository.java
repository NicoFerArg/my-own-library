package com.libreriapropia.libros.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.libreriapropia.libros.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
