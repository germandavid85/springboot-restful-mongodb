package gpotes.examples.mongospring.app;

import gpotes.examples.mongospring.domain.Company;
import gpotes.examples.mongospring.domain.Person;
import gpotes.examples.mongospring.service.IPersonService;
import gpotes.examples.mongospring.service.PersonService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
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
     * @param firstName
     * @param lastName
     * @return
     */
    @RequestMapping("/saveperson")
    public Person save(
        @RequestParam(value = "firstname", defaultValue = "Hello")
        final String firstName,
        @RequestParam(value = "lastname", defaultValue = "World")
        final String lastName,
        @RequestParam(value = "profession")
        final String profession,
        @RequestParam (value = "latitude")
        final int latitude,
        @RequestParam (value = "longitude")
        final int longitude,
        @RequestParam (value = "orgname")
        final String[] orgName,
        @RequestParam (value = "headquarter")
        final String[] headQuarter)
    {
        int [] location = new int[2];
        location[0] = longitude;
        location[1] = latitude;
        
        List<Company> companies = new ArrayList<Company>();
        
        for (int index = 0; index < orgName.length; index++)
        {
            companies.add(new Company(orgName[index], headQuarter[index]));
        }
        
        return personService.save(new Person(firstName, lastName, profession, location, companies));
    }
}