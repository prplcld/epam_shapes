package by.silebin.shapes.reader;

import by.silebin.shapes.exception.ShapeFileReaderException;
import by.silebin.shapes.validator.CubeAsStringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeFileReader {

    private static final Logger LOGGER = LogManager.getLogger(ShapeFileReader.class.getName());

    public List<String> readFromFile(String stringPath) throws ShapeFileReaderException {

        LOGGER.info("reading from file");

        Path path = Paths.get(stringPath);
        File file = new File(stringPath);
        if (!file.exists()) {
            LOGGER.error("no such file");
            throw new ShapeFileReaderException("No such file");
        }
        List<String> parameters = null;

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {

            parameters = bufferedReader.lines()
                    .filter(CubeAsStringValidator::isValidString)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (parameters != null) {
            return parameters;
        } else {
            LOGGER.error("no parameters found in file");
            throw new ShapeFileReaderException();
        }
    }
}
