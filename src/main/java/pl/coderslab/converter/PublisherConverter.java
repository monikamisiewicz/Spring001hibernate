package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.model.Publisher;
import pl.coderslab.repository.PublisherRepository;

public class PublisherConverter implements Converter<String, Publisher> {

	@Autowired
	private PublisherRepository publisherRepository;

	@Override
	public Publisher convert(String s) {
		return publisherRepository.findById(Long.parseLong(s));
	}
}
