package com.midominio.evaluable2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.midominio.evaluable2.dao.LibroRepository;
import com.midominio.evaluable2.entity.Libro;

@Service
public class LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	public long count() {
		return libroRepository.count();
	}
	
	public boolean existById(Long id) {
		return libroRepository.existsById(id);
	}
	
	public Iterable<Libro> findAll(){
		return libroRepository.findAll();
	}
	
	public Libro findById(Long id) {
		return libroRepository.findById(id).orElse(null);
	}
	
	public void deleteById(Long id) {
		libroRepository.deleteById(id);
	}
	
	public void deleteAll() {
		libroRepository.deleteAll();
	}
	
	public Libro save(Libro libro) {
		return libroRepository.save(libro);
	}
	
	public Optional<Libro> findOptionalById(Long id) {
		return libroRepository.findById(id);
	}
	
	public List<Libro> findByAuthor(String author) {
		return libroRepository.findByAuthor(author);
	}
	
	public Page<Libro> listar(Pageable pageable) {
		return libroRepository.findAll(pageable);
	}
	/*
	private Long id;
	private String name;
	private String author;
	private int pages;
	private int samples;
	 */
}
