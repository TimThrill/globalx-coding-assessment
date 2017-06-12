package test;

import app.FileIO;
import app.Name;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by admin on 12/06/2017.
 */
class FileIOTest {
    private String testString = "firstname lastname";
    private Path readFile;

    @BeforeEach
    void setUp() {
        readFile = Paths.get("./test-unsorted-names-list.txt");
        testString = "firstname lastname";

        byte[] writeContent = testString.getBytes();
        try {
            Files.write(readFile, writeContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        try {
            Files.delete(readFile);
        } catch (Exception e) {
            System.out.println("Delete test file failed");
            System.out.println(e.getStackTrace());
        }
    }

    @Test
    void writeToFile() {
        String writeFilePath = "./test-sorted-names-list.txt";
        String name1 = "Cong MA";
        String name2 = "Cong Fei Lao";
        List<String> expectedNames = new ArrayList<>();
        expectedNames.add(name1);
        expectedNames.add(name2);

        List<Name> names = new ArrayList<>();
        names.add(new Name());
        names.get(0).parseName(name1);
        names.add(new Name());
        names.get(1).parseName(name2);

        FileIO.writeToFile(writeFilePath, names);

        try {
            File f = new File(writeFilePath);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            int cnt = 0;
            while ((readLine = b.readLine()) != null) {
                assertEquals(expectedNames.get(cnt), readLine);
                cnt++;
            }
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void readFromFile() {
        List<String> readContent = FileIO.readFromFile("./test-unsorted-names-list.txt");
        assertEquals(testString, readContent.get(0));
    }

    @Test
    void readFromFileWithIncorrectPath() {
        List<String> readContent = FileIO.readFromFile("");
        assertTrue(readContent.isEmpty());
    }
}