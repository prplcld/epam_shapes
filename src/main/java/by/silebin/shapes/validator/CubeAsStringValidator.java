package by.silebin.shapes.validator;

public class CubeAsStringValidator {

    private static final String CUBE_AS_STRING_REGEX = "(([+-]?([0-9]*[.])?[0-9]+)\\s+){23}[+-]?([0-9]*[.])?[0-9]+";

    public static boolean isValidString(String cubeString) {
        return cubeString.matches(CUBE_AS_STRING_REGEX);
    }
}
