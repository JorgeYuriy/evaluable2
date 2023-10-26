package com.midominio.evaluable2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.midominio.evaluable2.service.LibroService;
import com.midominio.evaluable2.service.UsuarioService;

@Controller
public class HomeController {

	@Autowired
	private LibroService libroService;
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping({"/", "/home"})
	public String homeLander(Model model) {
		model.addAttribute("titulo","Inicio");
		model.addAttribute("tituloH1", "Proyecto de examen 'Evaluable-2'");
		model.addAttribute("parrafo1", "Se ha implementado un proyecto de biblioteca para gestionar los siguientes datos básicos (entidades):");
		model.addAttribute("parrafo2", "Libro (la base de datos incluye el número de ejemplares del libro);");
		model.addAttribute("parrafo3", "Usuario (la entidad incluye una lista de libros prestados de la biblioteca).");
		model.addAttribute("parrafo4", "La DAO se organiza mediante un repositorio de interfaz.");
		model.addAttribute("parrafo5", "Controladores:");
		model.addAttribute("parrafo6", "Controlador de página de inicio independiente.");
		model.addAttribute("parrafo7", "El controlador de la entidad Libro contiene funciones para contar el número de títulos de libros, registrar un libro nuevo, eliminar un título por su id, cambiar datos sobre el libro, proporcionar una lista de títulos con el número de ejemplares (página por página), filtrar libros por un autor específico y borrar la base de datos del libro.");
		model.addAttribute("parrafo8", "El controlador de la entidad Usuario contiene funciones para contar el número de usuarios, registrar un nuevo usuario, eliminar un usuario, cambiar los datos del usuario, proporcionar una lista de usuarios (página por página) y borrar la base de datos de usuarios.");
		model.addAttribute("parrafo9", "El programa proporciona un servicio para gestionar excepciones 404 y algunas excepciones de la serie 500.");
		model.addAttribute("parrafo10", "Las plantillas HTML se organizan mediante FlashMessenger y Bootstrap y se construyen con evitación de volver a escribir el marcado repetitivo.");
		model.addAttribute("parrafo11", "La página de inicio muestra el logotipo personal del autor con un enlace a su perfil de LinkedIn.");
		model.addAttribute("parrafo12", "El programa proporciona un servicio API-rest para desarrolladores.");
		model.addAttribute("parrafo13", "La base de datos es autorenovable y se recrea con los datos iniciales utilizando el driver H2");
		model.addAttribute("parrafo14", "El proyecto se publica a través de un repositorio público de GitHub.");
		model.addAttribute("cantidadDeLibros", "cantidad de libros: " + libroService.count());
		model.addAttribute("cantidadDeUsuarios", "cantidad de usuarios: " + usuarioService.count());
		model.addAttribute("parrafo120", "Servicios API-rest creados para la entidad Libro:");
		model.addAttribute("parrafo121", "ver la lista de libros: listadoLibrosRest()");
		model.addAttribute("parrafo122", "ver información sobre un libro por su número de identificación: libroPorId(id)");
		model.addAttribute("parrafo123", "borrar un titulo de libro de la lista por su número de identificación: libroBorrar(id)");
		model.addAttribute("parrafo124", "crear un registro sobre un libro nuevo: libroCrear(libro)");
		model.addAttribute("parrafo125", "editar una entrada de libro libroActualizar(libro)");
		return "home";
	}

}
