package test;

import app.Name;
import app.Sorting;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by admin on 12/06/2017.
 */
class SortingTest {
    @Test
    void sortingByLastName() {
        List<Name> expectedNames = new ArrayList<Name>();
        String[] givenName = new String[3];
        givenName[0] = "Cong";
        expectedNames.add(new Name(givenName, "MA"));
        String[] givenName2 = new String[3];
        givenName2[0] = "Qiao";
        expectedNames.add(new Name(givenName2, "Song"));

        List<Name> testNames = new ArrayList<>();
        testNames.add(new Name(givenName2, "Song"));
        testNames.add(new Name(givenName, "MA"));

        Sorting sort = new Sorting();
        sort.sortingByLastName(testNames);

        for (int i = 0; i < testNames.size(); i++) {
            assertEquals(expectedNames.get(i).getLastName(), testNames.get(i).getLastName());
            assertArrayEquals(expectedNames.get(i).getGivenName(), testNames.get(i).getGivenName());
        }
    }

}