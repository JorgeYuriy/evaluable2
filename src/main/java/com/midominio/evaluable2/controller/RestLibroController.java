package com.midominio.evaluable2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.midominio.evaluable2.entity.Libro;
import com.midominio.evaluable2.service.LibroService;

@RestController
public class RestLibroController {

	@Autowired
	private LibroService libroService;
	
	@GetMapping("/libros/rest/all")
	public Iterable<Libro> listadoLibrosRest() {
		return libroService.findAll();
	}
	
	@GetMapping("/libros/rest/id/{id}")
	public Libro libroPorId(@PathVariable Long id) {
		return libroService.findById(id);
	}
	
	@GetMapping("/libros/rest/delete-by-id/{id}")
	public void libroBorrar(@PathVariable Long id) {
		libroService.deleteById(id);
	}
	
	@PostMapping("/libros/rest/edit")
	public Libro libroCrear(@RequestBody Libro libro) {
		return libroService.save(libro);
	}
	
	@PutMapping("/libros/rest/edit")
	public Libro libroActualizar(@RequestBody Libro libro) {
		return libroService.save(libro);
	}
	
}
