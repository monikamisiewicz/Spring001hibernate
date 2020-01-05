package pl.coderslab.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.PublisherRepository;

@Controller
@RequestMapping("/form-author")
@RequiredArgsConstructor
public class AuthorFormController {

	private final AuthorRepository authorRepository;

	@GetMapping
	public String getForm(Model model) {
		model.addAttribute("author", new Author());
		return "authors/form";
	}

	@PostMapping
	public String saveBook(@ModelAttribute Author book) {
		authorRepository.create(book);
		return "redirect:/form-author/list";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable long id, Model model) {
		Author author = authorRepository.findById(id);
		model.addAttribute("author", author);
		return "authors/edit";
	}

	@PostMapping("/edit")
	public String update(@ModelAttribute Author author) {
		authorRepository.update(author);
		return "redirect:/form-author/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteCheck(@PathVariable long id, Model model) {
		model.addAttribute("authorId", id);
		return "authors/delete";
	}

	@GetMapping("/delete-action/{id}")
	public String delete(@PathVariable long id, @RequestParam("action") boolean action) {
		if (action) {
			authorRepository.delete(authorRepository.findById(id));
		}
		return "redirect:/form-author/list";
	}


	@GetMapping("/list")
	public String getList(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		return "authors/list";
	}

}
