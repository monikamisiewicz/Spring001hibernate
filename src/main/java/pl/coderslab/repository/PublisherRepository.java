package pl.coderslab.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PublisherRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Publisher create(Publisher publisher) {
        entityManager.persist(publisher);
        return publisher;
    }

    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }

    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void delete(Publisher publisher) {
        entityManager.remove(entityManager.contains(publisher) ?
                publisher : entityManager.merge(publisher));
    }


	public List<Publisher> getAll() {
		Query query = entityManager.createQuery("SELECT p FROM Publisher p");
		return query.getResultList();
	}
}
