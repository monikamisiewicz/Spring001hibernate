package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.PublisherRepository;

@Controller
@RequestMapping("/publishers")
public class PublisherController {
    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("/{id}")
	@ResponseBody
    public Publisher read(@PathVariable long id) {
        return publisherRepository.findById(id);
    }

    @PostMapping()
	@ResponseBody
    public Publisher create() {
    	Publisher publisher = new Publisher(null, "Testowy pub");
        return publisherRepository.create(publisher);
    }

    @PutMapping("/{id}")
	@ResponseBody
    public void update(@PathVariable long id, @RequestBody Publisher newPublisher) {
        Publisher publisher = publisherRepository.findById(id);
        publisher = newPublisher;
        publisherRepository.update(publisher);
    }

    @DeleteMapping("/{id}")
	@ResponseBody
    public void delete(@PathVariable long id) {
        Publisher publisher = publisherRepository.findById(id);
        publisherRepository.delete(publisher);
    }
}
