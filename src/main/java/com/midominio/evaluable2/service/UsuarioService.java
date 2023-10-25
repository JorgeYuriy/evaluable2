package com.midominio.evaluable2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.midominio.evaluable2.dao.UsuarioRepository;
import com.midominio.evaluable2.entity.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public long count() {
		return usuarioRepository.count();
	}
	
	public boolean existById(Long id) {
		return usuarioRepository.existsById(id);
	}
	
	public Iterable<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public void deleteAll() {
		usuarioRepository.deleteAll();
	}
	
	public Usuario save (Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> findOptionalById(Long id) {
		return usuarioRepository.findById(id);
	}
	
	public Page<Usuario> listar(Pageable pageable){
		return usuarioRepository.findAll(pageable);
	}
	
	/*
	private Long id;
	private String name;
	private String numeroId;
	private String phone;
	 */
}
