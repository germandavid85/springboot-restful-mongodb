package gpotes.examples.mongospring.service;

import gpotes.examples.mongospring.domain.Person;

import java.util.List;

/**
 * @author gpotes
 *
 */
public interface IPersonService
{
    List<Person> findAll();
    
    Person findById(String id);
    
    Person save(Person person);
}
