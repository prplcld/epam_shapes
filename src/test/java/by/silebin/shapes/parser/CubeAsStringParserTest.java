package by.silebin.shapes.parser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CubeAsStringParserTest {

    @DataProvider(name = "strings-data-provider")
    public Object[][] areaProvider() {
        return new Object[][]{
                {"1 2 3 1 2 3 1 2 3 1 2 3 1 2 3 1 2 3 1 2 3 1 2 3", new double[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3}}
        };
    }

    @Test(dataProvider = "strings-data-provider")
    public void testParse(String str, double[] expected) {
        double[] actual = CubeAsStringParser.parse(str);
        Assert.assertEquals(actual, expected);
    }
}
