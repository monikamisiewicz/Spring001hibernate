package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.PublisherRepository;

import java.util.List;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/books")
@Transactional
public class BookController {
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookController(BookRepository bookRepository, PublisherRepository publisherRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Book read(@PathVariable long id) {
        Book book = bookRepository.finById(id);
        return book;
    }

    @PostMapping
    @ResponseBody
    public Book create() {
        Publisher publisher = new Publisher();
        publisher.setName("new publisher");
        publisher = publisherRepository.create(publisher);

        List<Author> authors = authorRepository.findAll();

        Book book = new Book();
        book.setTitle("title");
        book.setRating(1);
        book.setDescription("description");
        book.setPublisher(publisher);
        book.setAuthors(authors);
        return bookRepository.create(book);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Book newBook) {
        Book book = bookRepository.finById(id);
        book = newBook;
        bookRepository.update(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Book book = bookRepository.finById(id);
        bookRepository.delete(book);
    }

    @GetMapping("/rating/{rating}")
	@ResponseBody
	public List<Book> getByRating(@PathVariable int rating) {
    	return bookRepository.findAllByRating(rating);
	}

	@GetMapping("/pub/{id}")
	@ResponseBody
	public List<Book> getByPublisher(@PathVariable long id) {
    	Publisher publisher = publisherRepository.findById(id);
		return bookRepository.getAllByPublisher(publisher);
	}

	@GetMapping("/pubs")
	@ResponseBody
	public List<Book> getWithAnyPubs() {
		return bookRepository.getAllWithPublishers();
	}

	@GetMapping("/author/{id}")
	@ResponseBody
	public List<Book> getByAuthor(@PathVariable long id) {
    	Author author = authorRepository.findById(id);
		return bookRepository.getAllByAuthor(author);
	}
}
