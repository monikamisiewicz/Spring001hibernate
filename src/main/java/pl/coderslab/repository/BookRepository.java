package pl.coderslab.repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import org.springframework.stereotype.Repository;

import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookRepository {
	@PersistenceContext
	EntityManager entityManager;

	public Book create(Book book) {
		entityManager.persist(book);
		return book;
	}

	public void update(Book book) {
		entityManager.merge(book);
	}

	public Book finById(long id) {
		return entityManager.find(Book.class, id);
	}

	public void delete(Book book) {
		entityManager.remove(entityManager.contains(book) ?
				book : entityManager.merge(book));
	}

	public List<Book> findAll() {
		Query query = entityManager.createQuery("SELECT b FROM Book b");
		return query.getResultList();
	}

	public List<Book> findAllByRating(int rating) {
		Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.rating = :rating");
		query.setParameter("rating", rating);
		return query.getResultList();
	}

	public List<Book> getAllWithPublishers() {
		Query query = entityManager.createQuery("SELECT b FROM Book b where b.publisher IS NOT NULL");
		return query.getResultList();
	}

	public List<Book> getAllByPublisher(Publisher publisher) {
		Query query = entityManager.createQuery("SELECT b FROM Book b where b.publisher = :publisher");
		query.setParameter("publisher", publisher);
		return query.getResultList();
	}

	public List<Book> getAllByAuthor(Author author) {
		Query query = entityManager.createQuery("SELECT b FROM Book b WHERE :authors MEMBER OF b.authors");
		query.setParameter("authors", author);
		return query.getResultList();
	}
}
