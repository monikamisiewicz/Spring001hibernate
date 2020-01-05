package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Author create(Author author) {
        entityManager.persist(author);
        return author;
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author));
    }

    public List<Author> findAll() {
        Query query = entityManager.createQuery("select a from Author a");
        return query.getResultList();
    }
}
