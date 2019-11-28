package com.libreriapropia.libros.service;

import java.util.List;
import java.util.Optional;

import com.libreriapropia.libros.model.Libro;

public interface LibroServiceInterface {

	String addLibro(Libro libro);
	List<Libro> getLibro();
	Optional<Libro> getLibroById(Integer id);
	List<Libro> findByNameLike(String name);
	List<Libro> findByAutorLike(String autor);
	String deleteLibroById(Integer id);
	
	
}
