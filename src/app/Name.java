package app;

/**
 * Created by admin on 12/06/2017.
 */
public class Name {
    private String[] givenName = new String[3];
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

    public void parseName(String str) {
        String[] splitStr = str.split("\\s+");
        this.lastName = splitStr[splitStr.length - 1];
        for(int i = 0; i < (splitStr.length - 1); i++) {
            this.givenName[i] = splitStr[i];
        }
    }
}
