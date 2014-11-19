package gpotes.examples.mongospring.service;

import gpotes.examples.mongospring.domain.Person;
import gpotes.examples.mongospring.repository.PersonRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gpotes
 *
 */
@Component
@Transactional
public class PersonService implements IPersonService
{
    private PersonRepository personRepository;
    
    @Autowired
    public PersonService(final PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }


    @Override
    public List<Person> findAll()
    {
        return personRepository.findAll();
    }

    @Override
    public Person save(final Person person)
    {
        return personRepository.save(person);
    }

}
