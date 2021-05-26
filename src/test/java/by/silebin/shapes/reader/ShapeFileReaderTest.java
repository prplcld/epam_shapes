package by.silebin.shapes.reader;

import by.silebin.shapes.exception.ShapeFileReaderException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeFileReaderTest {


    private static final String PATH = "data/test.txt";
    private ShapeFileReader shapeFileReader;

    private static final String[] expectedArray = new String[]{"1 2 3 1 2 3 1 2 3 1 2 3 1 2 3 1 2 3 1 2 3 1 2 3", "1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0 1.0"};

    @BeforeTest
    public void init() {
        shapeFileReader = new ShapeFileReader();
    }

    @Test
    public void testReadFromFile() throws ShapeFileReaderException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(PATH);
        String path = new File(url.getFile()).getAbsolutePath();
        List<String> actual =  shapeFileReader.readFromFile(path);
        List<String> expected = Arrays.stream(expectedArray).collect(Collectors.toList());
        Assert.assertEquals(actual, expected);
    }
}
