package gpotes.examples.mongospring.app;

import gpotes.examples.mongospring.domain.Person;
import gpotes.examples.mongospring.repository.PersonRepository;
import gpotes.examples.mongospring.service.PersonService;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    @Mock
    private PersonRepository mockPersonRepository;
    private PersonController personController;

    private Person person1 = new Person();

    @Before
    public void setup() {
        setupPerson();
        when(mockPersonRepository.findAll()).thenReturn(Arrays.asList(person1));
        PersonService personService = new PersonService(mockPersonRepository);

        personController = new PersonController(personService);
    }

    @Test
    public void findAllTest() {
        List<Person> allPersons = personController.findAll();

        assertEquals(1, allPersons.size());

        Person actualPerson = allPersons.get(0);
        assertEquals("German", actualPerson.getFirstName());
        assertEquals("Potes", actualPerson.getLastName());
        assertEquals("1234", actualPerson.getId());
    }

    private void setupPerson(){
        person1.setFirstName("German");
        person1.setLastName("Potes");
        person1.setId("1234");
    }
}
