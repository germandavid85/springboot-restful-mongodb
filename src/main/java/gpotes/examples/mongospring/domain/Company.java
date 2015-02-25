package gpotes.examples.mongospring.domain;

import org.springframework.data.mongodb.core.index.Indexed;

public class Company
{
    @Indexed (unique = true)
    private String orgName;
    private String headquarter;

    public Company() {}

    public Company(String orgName, String headquarter) {
        this.orgName = orgName;
        this.headquarter = headquarter;
    }

    /**
     * @return Returns the orgName.
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName
     *            The orgName to set.
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * @return Returns the headquarter.
     */
    public String getHeadquarter() {
        return headquarter;
    }

    /**
     * @param headquarter
     *            The headquarter to set.
     */
    public void setHeadquarter(String headquarter) {
        this.headquarter = headquarter;
    }
}
