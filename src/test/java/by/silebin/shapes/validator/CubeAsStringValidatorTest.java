package by.silebin.shapes.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CubeAsStringValidatorTest {


    @DataProvider(name = "strings-data-provider")
    public Object[][] stringsProvider() {
        return new Object[][] {
                {"", false},
                {"1 2 3 1 2 3 1 2 3 1 2 3 1 2 3 1 2 3 1 2 3 1 2 3", true}
        };
    }

    @Test(dataProvider = "strings-data-provider")
    public void testIsValidString(String str, boolean expected) {
        boolean actual = CubeAsStringValidator.isValidString(str);
        Assert.assertEquals(actual, expected);
    }
}
