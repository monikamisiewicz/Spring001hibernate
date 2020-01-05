package pl.coderslab.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.model.Student;

@Controller
@RequestMapping("/students")
public class StudentController {


	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("student", new Student());
		return "/students/form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Student student, Model model) {
		model.addAttribute("student", student);
		return "/students/saved";
	}

	@ModelAttribute("gender")
	public List<String> gender() {
		return Arrays.asList("Male","Female");
	}

	@ModelAttribute("countries")
	public List<String> countries() {
		return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
	}

	@ModelAttribute("programmingSkills")
	private List<String> programmingSkills() {
		return Arrays.asList("Java", "Ruby", "JavaScript", "HTML", "Drools", "Android");
	}

	@ModelAttribute("hobbies")
	private List<String> hobbies() {
		return Arrays.asList("Cars", "Games", "Music", "Movies", "Books", "Sport");
	}
}
