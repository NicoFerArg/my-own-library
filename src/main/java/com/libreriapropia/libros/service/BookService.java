package com.libreriapropia.libros.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreriapropia.libros.dao.BookRepository;
import com.libreriapropia.libros.model.Book;
import com.libreriapropia.sequence.dao.SequenceDaoInterface;

@Service
public class BookService implements BookServiceInterface{

	private static final String BOOK_SEQ_KEY = "Book";
	
	@Autowired
	private SequenceDaoInterface sequenceDao;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public String addBook(Book book) {
		book.setId(sequenceDao.getNextSequenceId(BOOK_SEQ_KEY));
		bookRepository.save(book);
		return "Added product with id: " + book.getId();
	}

	@Override
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Optional<Book> getBookById(Integer id) {
		return bookRepository.findById(id);
	}

	@Override
	public List<Book> findByNameLike(String name) {
		List<Book> libroList = bookRepository.findAll();
		List<Book> libroListFiltered = 
				libroList.stream()
				.filter(l -> l.getName().contains(name))
				.collect(Collectors.toList());
		return libroListFiltered;
	}

	@Override
	public List<Book> findByAuthorLike(String author) {
		List<Book> libroList = bookRepository.findAll();
		List<Book> libroListFiltered = 
				libroList.stream()
				.filter(l -> l.getAuthor().contains(author))
				.collect(Collectors.toList());
		return libroListFiltered;
	}

	@Override
	public String deleteBookById(Integer id) {
		bookRepository.deleteById(id);
		return "Deleted product with id: " + id;
	}
	
}
