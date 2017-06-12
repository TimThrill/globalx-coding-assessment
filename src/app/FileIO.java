package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 12/06/2017.
 */
public class FileIO {
    public static void writeToFile(String path, List<Name> names) {

    }

    public static List<String> readFromFile(String path) {
        List<String> res = new ArrayList<>();
        try {
            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            System.out.println("Reading file using Buffered Reader");
            while ((readLine = b.readLine()) != null) {
                res.add(readLine);
            }
            b.close();
        } catch (IOException e) {
            System.out.println("Read file: " + path + " failed");
        }
        return res;
    }
}
