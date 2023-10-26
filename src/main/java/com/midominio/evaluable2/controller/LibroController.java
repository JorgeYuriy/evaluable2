package com.midominio.evaluable2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.midominio.evaluable2.entity.Libro;
import com.midominio.evaluable2.service.LibroService;
import com.midominio.evaluable2.utils.PageRender;

@Controller
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@GetMapping("/libros/count")
	public String numeroLibros(Model model) {
		model.addAttribute("tituloH1", "Número libros");
		model.addAttribute("numLibros", libroService.count() + " 😎");
		return "libros/count";
	}
	
	@GetMapping("/libros/libros")
	public String listadoLibros(@RequestParam(defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Libro> libros = libroService.listar(pageRequest);
		PageRender<Libro> pageRender = new PageRender<>("/libros/libros", libros);
		model.addAttribute("tituloH1", "Todos libros");
		model.addAttribute("libros", libros);
		model.addAttribute("numLibros", libroService.count());
		model.addAttribute("page", pageRender);
		return "libros/libros";
	}
	
	@GetMapping("/libros/libro/{id}")
	public String unLibro(@PathVariable Long id, Model model) {
		model.addAttribute("tituloH1", "El libro solicitado");
		model.addAttribute("libro", libroService.findById(id));
		model.addAttribute("idSolicitado", id);
		return "libros/libro";
	}
	
	@GetMapping("/libros/libro_borrar/{id}")
	public String deleteLibroById(@PathVariable Long id, Model model, RedirectAttributes flash) {
		if (libroService.existById(id)) {
			libroService.deleteById(id);
			flash.addFlashAttribute("warning", "Libro con id " + id + " borrado con éxito");
		} else {
			flash.addFlashAttribute("error", "Libro con id " + id + " no se puede borrar");
		}
		return "redirect:/libros/libros";
	}
	
	@GetMapping("/libros/libro_editar")
	public String crearLibro(Model model) {
		model.addAttribute("tituloH1", "Formulario de libro");
		model.addAttribute("libro", new Libro());
		return "libros/libro_editar";
	}
	
	@PostMapping("/libros/libro_editar")
	public String guardarLibro(@Validated Libro libro, BindingResult result, Model model, RedirectAttributes flash) {
		if (result.hasErrors()) {
			model.addAttribute("tituloH1", "Formulario de libro");
			return "libros/libro_editar";
		}
		libroService.save(libro);
		flash.addFlashAttribute("success", "Libro guardado con éxito");
		return "redirect:/libros/libros";
	}
	
	@GetMapping("/libros/libro_editar/{id}")
	public String mostrarLibroConDatos(@PathVariable Long id, Model model) {
		model.addAttribute("libro", libroService.findOptionalById(id));
		model.addAttribute("tituloH1", "Formulario de libro");
		return "libros/libro_editar";
	}
	
	@GetMapping("/libros/libros-de-autor/{author}")
	public String losLibrosPorAutor(@PathVariable String author, @RequestParam(defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Libro> libros = libroService.findByAuthor(pageRequest, author);
		PageRender<Libro> pageRender = new PageRender<>("/libros/libros" + author, libros);
		model.addAttribute("tituloH1", "Los libros del autor solicitado");
		model.addAttribute("libros", libros);
		model.addAttribute("page", pageRender);
		model.addAttribute("authorSolicitado", author);
		return "libros/libros-de-autor";
	}
}
