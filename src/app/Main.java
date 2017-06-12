package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 12/06/2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Start application ...");
        List<Name> names = new ArrayList<>();
        if(args.length > 0) {
            String filePath = args[0];
            final String writePath = "./sorted-names-list.txt";

            // Read names from file
            List<String> content = FileIO.readFromFile(filePath);
            // Add these names to variable names
            for(int i = 0; i < content.size(); i++) {
                names.add(new Name());
                names.get(i).parseName(content.get(i));
            }

            // Sorting names by last name
            Sorting sort = new Sorting();
            sort.sortingByLastName(names);

            // Print sorted names to screen
            for(Name name : names) {
                System.out.println(name);
            }
            // Write sorted names to file
            FileIO.writeToFile(writePath, names);
        }
        System.out.println("End programme ...");
    }
}
