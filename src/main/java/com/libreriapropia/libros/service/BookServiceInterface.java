package com.libreriapropia.libros.service;

import java.util.List;
import java.util.Optional;

import com.libreriapropia.libros.model.Book;

public interface BookServiceInterface {

	String addBook(Book book);
	List<Book> getBooks();
	Optional<Book> getBookById(Integer id);
	List<Book> findByNameLike(String name);
	List<Book> findByAuthorLike(String author);
	String deleteBookById(Integer id);
	
	
}
