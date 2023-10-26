package com.midominio.evaluable2.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.evaluable2.dao.LibroRepository;
import com.midominio.evaluable2.entity.Libro;


@Service
public class LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	@Transactional(readOnly = true)
	public long count() {
		return libroRepository.count();
	}
	
	@Transactional(readOnly = true)
	public boolean existById(Long id) {
		return libroRepository.existsById(id);
	}
	
	@Transactional(readOnly = true)
	public Iterable<Libro> findAll(){
		return libroRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Libro findById(Long id) {
		return libroRepository.findById(id).orElse(null);
	}
	
	@Transactional
	public void deleteById(Long id) {
		libroRepository.deleteById(id);
	}
	
	@Transactional
	public void deleteAll() {
		libroRepository.deleteAll();
	}
	
	@Transactional
	public Libro save(Libro libro) {
		return libroRepository.save(libro);
	}
	
	@Transactional(readOnly = true)
	public Optional<Libro> findOptionalById(Long id) {
		return libroRepository.findById(id);
	}
	
	@Transactional(readOnly = true)
	public Page<Libro> findByAuthor(Pageable pageable, String author) {
		return libroRepository.findByAuthor(pageable, author);
	}
	
	@Transactional(readOnly = true)
	public Page<Libro> listar(Pageable pageable) {
		return libroRepository.findAll(pageable);
	}
	
	/*
	@Transactional(readOnly = true)
	public List<Libro> findByAutorText(String text){
		return libroRepository.findByAuthorLikeIgnoreCase("%" + text + "%");
	}
	*/
	/*
	private Long id;
	private String name;
	private String author;
	private int pages;
	private int samples;
	 */
}
