package com.libreriapropia.libros.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Libro")
public class Libro {

	@Id
	private Integer id;
	private String name;
	private String autor;
	private String editorial;
	
	public Libro() {
		super();
	}
	
	public Libro(Integer id, String name, String autor, String editorial) {
		super();
		this.id = id;
		this.name = name;
		this.autor = autor;
		this.editorial = editorial;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", name=" + name + ", autor=" + autor + ", editorial=" + editorial + "]";
	}
	
	
	
}
