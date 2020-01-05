package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Person create(Person person) {
        entityManager.persist(person);
        return person;
    }

    public Person read(long id) {
        return entityManager.find(Person.class, id);
    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public void delete(long id) {
        entityManager.remove(entityManager.find(Person.class, id));
    }
}
