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
@RequestMapping("/form-book")
@RequiredArgsConstructor
public class BookFormController {

	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	private final AuthorRepository authorRepository;

	@GetMapping
	public String getForm(Model model) {
		model.addAttribute("book", new Book());
		return "books/form";
	}

	@PostMapping
	public String saveBook(@ModelAttribute Book book) {
		bookRepository.create(book);
		return "redirect:/form-book/list";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable long id, Model model) {
		Book book = bookRepository.finById(id);
		model.addAttribute("book", book);
		return "books/edit";
	}

	@PostMapping("/edit")
	public String update(@ModelAttribute Book book) {
		bookRepository.update(book);
		return "redirect:/form-book/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteCheck(@PathVariable long id, Model model) {
		model.addAttribute("bookId", id);
		return "books/delete";
	}

	@GetMapping("/delete-action/{id}")
	public String delete(@PathVariable long id, @RequestParam("action") boolean action) {
		if (action) {
			bookRepository.delete(bookRepository.finById(id));
		}
		return "redirect:/form-book/list";
	}


	@GetMapping("/list")
	public String getList(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "books/list";
	}

	@ModelAttribute("ratings")
	public List<String> rating() {
		return Arrays.asList("1","2","3","4","5");
	}

	@ModelAttribute("publishers")
	public List<Publisher> publishers() {
		return publisherRepository.getAll();
	}

	@ModelAttribute("authors")
	public List<Author> authors() {
		return authorRepository.findAll();
	}

}
