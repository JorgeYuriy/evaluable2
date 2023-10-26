package com.midominio.evaluable2.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.midominio.evaluable2.entity.Libro;

public interface LibroRepository extends PagingAndSortingRepository<Libro, Long>, CrudRepository<Libro, Long> {

	List<Libro> findByAuthor(String autor);
	List<Libro> findByPages(int pages);
	List<Libro> findBySamples(int samples);
	Page<Libro> findByPages(Pageable pageable, int pages);
	Page<Libro> findBySamples(Pageable pageable, int samples);
	Page<Libro> findByAuthor(Pageable pageable, String author);
	
	/*
	@Query("select * from Libro p where p.autor like %?1%")
	public List<Libro> findByAuthorText(String text);
	
	public List<Libro> findByAuthorLikeIgnoreCase(String text);
	*/
}
