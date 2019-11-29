package com.libreriapropia.libros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.libreriapropia.libros", "com.libreriapropia.sequence"})
public class ListadoLibrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListadoLibrosApplication.class, args);
	}

}
