package com.libreriapropia.libros.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.libreriapropia.libros.model.Libro;
import com.libreriapropia.libros.service.LibroServiceInterface;

@RestController
public class LibroController {

	private final static Logger LOGGER = Logger.getLogger("com.libreriapropia.libros.controller.LibroController");
	
	@Autowired
	private LibroServiceInterface libroService;
	
	@RequestMapping(value="/libreria/addLibro",method=RequestMethod.POST,produces="application/json")
	public String addLibro(@RequestBody Libro libro) {
		return libroService.addLibro(libro);
	}
	
	@RequestMapping(value="/libreria/getLibros",method=RequestMethod.GET,produces="application/json")
	public List<Libro> getLibro() {
		return libroService.getLibro();
	}
	
	@RequestMapping(value="/libreria/getLibros/{id}",method=RequestMethod.GET,produces="application/json")
	public Optional<Libro> getLibroById(@PathVariable Integer id){
		LOGGER.log(Level.INFO,"El id es -> "+id);
		return libroService.getLibroById(id);
	}
	
	@RequestMapping(value="/libreria/getLibros/filter/{name}",method=RequestMethod.GET,produces="application/json")
	List<Libro> findByNameLike(@PathVariable String name){
		return libroService.findByNameLike(name);
	}
	
	@RequestMapping(value="/libreria/getLibros/filter2/{autor}",method=RequestMethod.GET,produces="application/json")
	List<Libro> findByAutorLike(@PathVariable String autor){
		return libroService.findByAutorLike(autor);
	}
	
	@RequestMapping(value="/libreria/deleteLibro/{id}",method=RequestMethod.DELETE,produces="application/json")
	String deleteLibroById(@PathVariable Integer id) {
		return libroService.deleteLibroById(id);
	}
	
}
