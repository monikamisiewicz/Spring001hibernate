package pl.coderslab.controller;


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
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.PublisherRepository;

@Controller
@RequestMapping("/form-publisher")
@RequiredArgsConstructor
public class PublisherFormController {

	private final PublisherRepository publisherRepository;

	@GetMapping
	public String getForm(Model model) {
		model.addAttribute("publisher", new Publisher());
		return "publishers/form";
	}

	@PostMapping
	public String saveBook(@ModelAttribute Publisher publisher) {
		publisherRepository.create(publisher);
		return "redirect:/form-publisher/list";

	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable long id, Model model) {
		Publisher publisher = publisherRepository.findById(id);
		model.addAttribute("publisher", publisher);
		return "publishers/edit";
	}

	@PostMapping("/edit")
	public String update(@ModelAttribute Publisher publisher) {
		publisherRepository.update(publisher);
		return "redirect:/form-publisher/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteCheck(@PathVariable long id, Model model) {
		model.addAttribute("publisherId", id);
		return "publishers/delete";
	}

	@GetMapping("/delete-action/{id}")
	public String delete(@PathVariable long id, @RequestParam("action") boolean action) {
		if (action) {
			publisherRepository.delete(publisherRepository.findById(id));
		}
		return "redirect:/form-publisher/list";
	}


	@GetMapping("/list")
	public String getList(Model model) {
		model.addAttribute("publishers", publisherRepository.getAll());
		return "publishers/list";
	}

}
