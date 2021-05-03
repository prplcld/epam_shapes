package by.silebin.shapes.reader;

import by.silebin.shapes.exception.ShapeFileReaderException;
import by.silebin.shapes.validator.CubeAsStringValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeFileReader {

    public List<String> readFromFile(String stringPath) throws ShapeFileReaderException {


        Path path = Paths.get(stringPath);
        List<String> parameters = null;

        try(BufferedReader bufferedReader = Files.newBufferedReader(path)){

            parameters = bufferedReader.lines()
                    .filter(CubeAsStringValidator::isValidString)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(parameters != null){
            return  parameters;
        }

        else throw new ShapeFileReaderException();
    }
}
