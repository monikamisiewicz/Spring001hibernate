package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.model.Author;
import pl.coderslab.repository.AuthorRepository;

public class AuthorConverter implements Converter<String, Author> {
	@Autowired
	private AuthorRepository authorRepository;


	@Override
	public Author convert(String s) {
		return authorRepository.findById(Long.parseLong(s));
	}
}
