package test;

import app.FileIO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        readFile = Paths.get("./unsorted-names-list.txt");
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
    }

    @Test
    void writeToFile() {
    }

    @Test
    void readFromFile() {
        List<String> readContent = FileIO.readFromFile("./unsorted-names-list.txt");
        assertEquals(testString, readContent.get(0));
    }

    @Test
    void readFromFileWithIncorrectPath() {
        List<String> readContent = FileIO.readFromFile("");
        assertTrue(readContent.isEmpty());
    }
}