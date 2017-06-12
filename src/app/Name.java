package app;

/**
 * Created by admin on 12/06/2017.
 */
public class Name {
    private String[] givenName;
    private String lastName;
    public String[] getGivenName() {
        return givenName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setGivenName(String[] givenName) {
        this.givenName = givenName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
