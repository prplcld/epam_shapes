package by.silebin.shapes.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CubeAsStringParser {

    private static final Logger LOGGER = LogManager.getLogger(CubeAsStringParser.class.getName());

    private static final String SEPARATOR = " ";

    public static double[] parse(String str){

        LOGGER.info("parsing data");
        String[] split = str.split(SEPARATOR);
        double[] doubleValues = Arrays.stream(split)
                .mapToDouble(Double::parseDouble)
                .toArray();
        return doubleValues;
    }
}
