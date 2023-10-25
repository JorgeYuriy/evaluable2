package com.midominio.evaluable2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorsController {
	
	@GetMapping("/500/{n}")
	public String e1(@PathVariable int n) {
		int x = n/0;
		return "500";
	}
	
	@GetMapping("/500/string/{s}")
	public String e2(@PathVariable String s) {
		String str = null;
		str.length();
		return "500";
	}

}
