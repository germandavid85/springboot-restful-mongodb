package gpotes.examples.mongospring.app;

import gpotes.examples.mongospring.domain.Person;
import gpotes.examples.mongospring.resources.PersonResource;
import gpotes.examples.mongospring.service.IPersonService;
import gpotes.examples.mongospring.service.PersonService;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gpotes
 *
 */
@RestController
@Component
public class PersonController
{
    private IPersonService personService;

    /**
     * @param personService
     */
    @Autowired
    PersonController(
        final PersonService personService)
    {
        this.personService = personService;
    }

    /**
     * @return
     */
    @RequestMapping("/persons")
    public List<Person> findAll()
    {
        return personService.findAll();
    }

    /**
     * @return
     */
    @RequestMapping("/person/")
    public Person findById(@RequestParam(value = "id") final String id)
    {
        return personService.findById(id);
    }

    /**
     * @return
     */
    @RequestMapping(value = "/saveperson", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody final Person person)
    {
        Person savedPerson = personService.save(person);
        HttpHeaders httpHeaders = new HttpHeaders();
        
        Link forOnePerson = new PersonResource(savedPerson).getLink("self");
        httpHeaders.setLocation(URI.create(forOnePerson.getHref()));
        

//        httpHeaders.setLocation(
//            ServletUriComponentsBuilder.fromCurrentRequest()
//            .path("person/{id}").buildAndExpand(savedPerson.getId()).toUri());
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }
}