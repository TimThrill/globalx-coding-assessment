package test;

import app.Name;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by admin on 12/06/2017.
 */
class NameTest {
    @Test
    void parseName() {
        String testString = "Cong Medium MA";
        Name name = new Name();
        name.parseName(testString);
        String[] expectedGivenName = new String[3];
        expectedGivenName[0] = "Cong";
        expectedGivenName[1] = "Medium";
        String expectedLastName = "MA";
        
        assertArrayEquals(expectedGivenName, name.getGivenName());
        assertEquals(expectedLastName, name.getLastName());
    }

}