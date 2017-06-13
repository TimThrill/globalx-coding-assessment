package app;

import java.util.List;

/**
 * Created by admin on 12/06/2017.
 */
public class Sorting {
    public void sortingByLastName(List<Name> names) {
        names.sort((name1, name2)->name1.getLastName().compareToIgnoreCase(name2.getLastName()));
    }
}
