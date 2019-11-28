package com.libreriapropia.libros.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreriapropia.libros.dao.LibroRepository;
import com.libreriapropia.libros.model.Libro;

@Service
public class LibroService implements LibroServiceInterface{

	@Autowired
	private LibroRepository libroRepository;
	
	@Override
	public String addLibro(Libro libro) {
		libroRepository.save(libro);
		return "Added product with id: " + libro.getId();
	}

	@Override
	public List<Libro> getLibro() {
		return libroRepository.findAll();
	}

	@Override
	public Optional<Libro> getLibroById(Integer id) {
		return libroRepository.findById(id);
	}

	@Override
	public List<Libro> findByNameLike(String name) {
		List<Libro> libroList = libroRepository.findAll();
		List<Libro> libroListFiltered = 
				libroList.stream()
				.filter(l -> l.getName().contains(name))
				.collect(Collectors.toList());
		return libroListFiltered;
	}

	@Override
	public List<Libro> findByAutorLike(String autor) {
		List<Libro> libroList = libroRepository.findAll();
		List<Libro> libroListFiltered = 
				libroList.stream()
				.filter(l -> l.getAutor().contains(autor))
				.collect(Collectors.toList());
		return libroListFiltered;
	}

	@Override
	public String deleteLibroById(Integer id) {
		libroRepository.deleteById(id);
		return "Deleted product with id: " + id;
	}
	
}
