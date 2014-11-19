package gpotes.examples.mongospring.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Person
{
    @Id
    private String id;
    @Field(value = "first_name")
    private String firstName;
    @Field(value = "last_name")
    private String lastName;
    private String profession;
    private int location[];
    private List<Company> companies;

    public Person() {}

    public Person(
        String firstName, String lastName, String profession, int [] location, List<Company> companies)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
        this.location = location;
        this.companies = companies;
    }

    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    

    /**
     * @return Returns the id.
     */
    public String getId()
    {
        return id;
    }

    /**
     * @param id The id to set.
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * @return Returns the firstName.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName The firstName to set.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return Returns the lastName.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName The lastName to set.
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return Returns the profession.
     */
    public String getProfession()
    {
        return profession;
    }

    /**
     * @param profession The profession to set.
     */
    public void setProfession(String profession)
    {
        this.profession = profession;
    }

    /**
     * @return Returns the location.
     */
    public int[] getLocation()
    {
        return location;
    }

    /**
     * @param location The location to set.
     */
    public void setLocation(int[] location)
    {
        this.location = location;
    }

    /**
     * @return Returns the companies.
     */
    public List<Company> getCompanies()
    {
        return companies;
    }

    /**
     * @param companies The companies to set.
     */
    public void setCompanies(List<Company> companies)
    {
        this.companies = companies;
    }

}
