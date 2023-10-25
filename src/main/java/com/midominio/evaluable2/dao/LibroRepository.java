package com.midominio.evaluable2.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.midominio.evaluable2.entity.Libro;
import java.util.List;



public interface LibroRepository extends PagingAndSortingRepository<Libro, Long>, CrudRepository<Libro, Long> {

	public List<Libro> findByAuthor(String author);
	public List<Libro> findByPages(int pages);
	public List<Libro> findBySamples(int samples);
	

}
