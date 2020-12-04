package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Persona;

@Controller
@RequestMapping("/ejemplopost")
public class PostController {
	
	// forma 1
	/*@GetMapping("/")
	public String redirect1() {
		return "redirect:/ejemplopost/form";
	}*/
	
	// forma 2
	@GetMapping("/")
	public RedirectView redirect2() {
		return new RedirectView("/ejemplopost/form");
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("persona", new Persona());
		return "formulario";
	}
	
	
	@PostMapping("/addpersona")
	public ModelAndView resultados(@ModelAttribute("persona") Persona persona) {
		ModelAndView mav = new ModelAndView("resultados");
		mav.addObject("persona", persona);
		return mav;
	}
	

}

