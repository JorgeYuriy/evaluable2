package com.midominio.evaluable2.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.midominio.evaluable2.entity.Usuario;


public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>, CrudRepository<Usuario, Long> {

	public List<Usuario> findByNumeroId(String numeroId);
	public List<Usuario> findByPhone(String phone);
}
