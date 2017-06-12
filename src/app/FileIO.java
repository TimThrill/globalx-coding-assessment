package app;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 12/06/2017.
 */
public class FileIO {
    public static void writeToFile(String path, List<Name> names) {
        try {
            File f = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            for(int i = 0; i < names.size(); i++) {
                String[] givenName = names.get(i).getGivenName();
                for(int j = 0; j < givenName.length; j++) {
                    if((givenName[j] != null) && !givenName[j].isEmpty()) {
                        bw.write(givenName[j] + " ");
                    }
                }
                bw.write(names.get(i).getLastName() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Write file: " + path + " failed");
            System.out.println(e.getStackTrace());
        }
    }

    /*
     * The method read file from a specific file line by line and return a List of those lines
     * @param path The path of file to read
     * @return A list of line contents in the file
     */
    public static List<String> readFromFile(String path) {
        List<String> res = new ArrayList<>();
        try {
            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                res.add(readLine);
            }
            b.close();
        } catch (IOException e) {
            System.out.println("Read file: " + path + " failed");
            System.out.println(e.getStackTrace());
        }
        return res;
    }
}
