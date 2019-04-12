package pl.coderslab.app.person;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    EntityManager entityManager;
    public void save(Person entity) {
        entityManager.persist(entity);
    }

    public void edit(Person entity){
        entityManager.merge(entity);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public List<Person> findAll(Person entity){
        Query query = entityManager.createQuery("SELECT a FROM " + Person.class + " a");
        List<Person> persons = query.getResultList();
        return persons;
    }


    public void delete(Person entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity)); }
}
