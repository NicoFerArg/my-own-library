package com.libreriapropia.libros.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Book")
public class Book {

	@Id
	private Long id;
	private String name;
	private String author;
	private String editorial;
	
	public Book() {
		super();
	}
	
	public Book(Long id, String name, String author, String editorial) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.editorial = editorial;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", name=" + name + ", author=" + author + ", editorial=" + editorial + "]";
	}
	
	
	
}
