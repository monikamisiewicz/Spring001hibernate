package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Person;
import pl.coderslab.model.PersonDetails;
import pl.coderslab.repository.PersonRepository;

@Controller
@RequestMapping("/persons")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @GetMapping("/form")
	public String form() {
    	return "/persons/form";
	}

	@GetMapping("/form1")
	public String form(Model model) {
    	model.addAttribute("person", new Person());
		return "/persons/form1";
	}

	@PostMapping("/save")
	public String saveForm(
			@RequestParam String login,
			@RequestParam String password,
			@RequestParam String email
	) {
    	Person person = new Person();
    	person.setLogin(login);
    	person.setPassword(password);
    	person.setEmail(email);
    	personRepository.create(person);
    	return "/persons/form";
	}

	@PostMapping("/save1")
	public String saveForm(@ModelAttribute Person person) {
		personRepository.create(person);
		return "/persons/form1";
	}

    @GetMapping("/{id}")
    @ResponseBody
    public Person findById(@PathVariable long id) {
        return personRepository.read(id);
    }

    @PostMapping
    @ResponseBody
    public Person save() {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Jaro");
        personDetails.setLastName("West");
        personDetails.setStreetNumber("17");
        personDetails.setStreet("Piękna");
        personDetails.setCity("Wroclaw");

        Person person = new Person();
        person.setLogin("west");
        person.setPassword("pass");
        person.setEmail("my@mail.com");
        person.setPersonDetails(personDetails);

        return personRepository.create(person);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Person newPerson) {
        Person person = personRepository.read(id);
        person = newPerson;

        personRepository.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        personRepository.delete(id);
    }
}
