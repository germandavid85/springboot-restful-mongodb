package gpotes.examples.mongospring.repository;

import gpotes.examples.mongospring.domain.Person;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends MongoRepository<Person, String>
{
    public Person findByFirstName(String firstName);
    public List<Person> findByLastName(String lastName);
}