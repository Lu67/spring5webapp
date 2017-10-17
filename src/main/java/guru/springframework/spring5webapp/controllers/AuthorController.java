package guru.springframework.spring5webapp.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {
	
	AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@GetMapping("/authors")
	public String showAuthors(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		return "authors";
	}
	
	

}
