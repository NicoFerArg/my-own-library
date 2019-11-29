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

import com.libreriapropia.libros.model.Book;
import com.libreriapropia.libros.service.BookServiceInterface;

@RestController
public class BookController {

	private final static Logger LOGGER = Logger.getLogger("com.libreriapropia.libros.controller.BookController");
	
	@Autowired
	private BookServiceInterface bookService;
	
	@RequestMapping(value="/library/addLibro",method=RequestMethod.POST,produces="application/json")
	public String addLibro(@RequestBody Book libro) {
		return bookService.addBook(libro);
	}
	
	@RequestMapping(value="/library/getLibros",method=RequestMethod.GET,produces="application/json")
	public List<Book> getLibro() {
		return bookService.getBooks();
	}
	
	@RequestMapping(value="/library/getLibros/{id}",method=RequestMethod.GET,produces="application/json")
	public Optional<Book> getLibroById(@PathVariable Integer id){
		LOGGER.log(Level.INFO,"El id es -> "+id);
		return bookService.getBookById(id);
	}
	
	@RequestMapping(value="/library/getLibros/filter/{name}",method=RequestMethod.GET,produces="application/json")
	List<Book> findByNameLike(@PathVariable String name){
		return bookService.findByNameLike(name);
	}
	
	@RequestMapping(value="/library/getLibros/filter2/{autor}",method=RequestMethod.GET,produces="application/json")
	List<Book> findByAutorLike(@PathVariable String autor){
		return bookService.findByAuthorLike(autor);
	}
	
	@RequestMapping(value="/library/deleteLibro/{id}",method=RequestMethod.DELETE,produces="application/json")
	String deleteLibroById(@PathVariable Integer id) {
		return bookService.deleteBookById(id);
	}
	
}
