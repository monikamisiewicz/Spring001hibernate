package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.repository.AuthorRepository;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Author read(@PathVariable long id) {
        return authorRepository.findById(id);
    }

    @PostMapping
    @ResponseBody
    public Author create() {
        Author author = new Author();
        author.setFirstName("imie");
        author.setLastName("mazwisko");
        return authorRepository.create(author);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Author newAuthor) {
        Author author = authorRepository.findById(id);
        author = newAuthor;
        authorRepository.update(author);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Author author = authorRepository.findById(id);
        authorRepository.delete(author);
    }
}
