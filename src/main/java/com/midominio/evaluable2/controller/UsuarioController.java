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

import com.midominio.evaluable2.entity.Usuario;
import com.midominio.evaluable2.service.UsuarioService;
import com.midominio.evaluable2.utils.PageRender;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios/count")
	public String numeroUsuarios(Model model) {
		model.addAttribute("tituloH1", "Número usuarios");
		model.addAttribute("numUsuarios", usuarioService.count() + " 😎");
		return "usuarios/count";
	}
	
	@GetMapping("/usuarios/usuarios")
	public String listadoUsuarios(@RequestParam(defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Usuario> usuarios = usuarioService.listar(pageRequest);
		PageRender<Usuario> pageRender = new PageRender<>("/usuarios/usuarios", usuarios);
		model.addAttribute("tituloH1", "Todos usuarios");
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("numUsuarios", usuarioService.count());
		model.addAttribute("page", pageRender);
		return "usuarios/usuarios";
	}
	
	@GetMapping("/usuarios/usuario/{id}")
	public String unUsuarios(@PathVariable Long id, Model model) {
		model.addAttribute("tituloH1", "El usuario solicitado");
		model.addAttribute("usuario", usuarioService.findById(id));
		model.addAttribute("idSolicitado", id);
		return "usuarios/usuario";
	}
	
	@GetMapping("/usuarios/usuario_borrar/{id}")
	public String deleteUsuarioById(@PathVariable Long id, Model model, RedirectAttributes flash) {
		if (usuarioService.existById(id)) {
			usuarioService.deleteById(id);
			flash.addFlashAttribute("warning", "Usuario con id " + id + " borrado con éxito");
		} else {
			flash.addFlashAttribute("error", "Usuario con id " + id + " no se puede borrar");
		}
		return "redirect:/usuarios/usuarios";
	}
	
	@GetMapping("/usuarios/usuario_editar")
	public String crearUsuario(Model model) {
		model.addAttribute("tituloH1", "Formulario de usuario");
		model.addAttribute("usuario", new Usuario());
		return "usuarios/usuario_editar";
	}
	
	@PostMapping("/usuarios/usuario_editar")
	public String guardarUsuario(@Validated Usuario usuario, BindingResult result, Model model, RedirectAttributes flash) {
		if (result.hasErrors()) {
			model.addAttribute("tituloH1", "Formulario de usuario");
			return "usuarios/usuario_editar";
		}
		usuarioService.save(usuario);
		flash.addFlashAttribute("success", "Usuario guardado con éxito");
		return "redirect:/usuarios/usuarios";
	}
	
	@GetMapping("/usuarios/usuario_editar/{id}")
	public String mostrarUsuarioConDatos(@PathVariable Long id, Model model) {
		model.addAttribute("usuario", usuarioService.findOptionalById(id));
		model.addAttribute("tituloH1", "Formulario de usuario");
		return "usuarios/usuario_editar";
	}
}
