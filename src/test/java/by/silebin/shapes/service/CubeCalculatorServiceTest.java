package by.silebin.shapes.service;

import by.silebin.shapes.entity.Cube;
import by.silebin.shapes.entity.Dot;
import by.silebin.shapes.exception.ShapeException;
import by.silebin.shapes.service.impl.CubeCalculatorServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CubeCalculatorServiceTest {

    private CubeCalculatorService cubeCalculatorService;

    @BeforeTest
    public void init(){
        cubeCalculatorService = new CubeCalculatorServiceImpl();
    }

    private static final Dot[] dots;
    private static final Dot[] dots1;

    static {
        dots = new Dot[8];
        dots[0] = new Dot(0, 0, 1);
        dots[1] = new Dot(1, 0, 1);
        dots[2] = new Dot(1, 1, 1);
        dots[3] = new Dot(0, 1, 1);
        dots[4] = new Dot(0, 0, 0);
        dots[5] = new Dot(1, 0 , 0);
        dots[6] = new Dot(1, 1, 0);
        dots[7] = new Dot(0, 1, 0);

        dots1 = new Dot[8];
        dots1[0] = new Dot(0, 0, 2);
        dots1[1] = new Dot(2, 0, 2);
        dots1[2] = new Dot(2, 2, 2);
        dots1[3] = new Dot(0, 2, 2);
        dots1[4] = new Dot(0, 0, 0);
        dots1[5] = new Dot(2, 0 , 0);
        dots1[6] = new Dot(2, 2, 0);
        dots1[7] = new Dot(0, 2, 0);
    }

    @DataProvider(name = "perimeter-data-provider")
    public Object[][] perimeterProvider() throws ShapeException {
        return new Object[][] {
                {new Cube(dots[0], dots[1], dots[2], dots[3], dots[4], dots[5], dots[6], dots[7]), 12},
                {new Cube(dots1[0], dots1[1], dots1[2], dots1[3], dots1[4], dots1[5], dots1[6], dots1[7]), 24}
        };
    }

    @DataProvider(name = "area-data-provider")
    public Object[][] areaProvider() throws ShapeException {
        return new Object[][] {
                {new Cube(dots[0], dots[1], dots[2], dots[3], dots[4], dots[5], dots[6], dots[7]), 6},
                {new Cube(dots1[0], dots1[1], dots1[2], dots1[3], dots1[4], dots1[5], dots1[6], dots1[7]), 24}

        };
    }

    @DataProvider(name = "volume-data-provider")
    public Object[][] volumeProvider() throws ShapeException {
        return new Object[][] {
                {new Cube(dots[0], dots[1], dots[2], dots[3], dots[4], dots[5], dots[6], dots[7]), 1},
                {new Cube(dots1[0], dots1[1], dots1[2], dots1[3], dots1[4], dots1[5], dots1[6], dots1[7]), 8}

        };
    }

    @Test(dataProvider = "perimeter-data-provider")
    public void testCountPerimeter(Cube cube, double expected){
        double actual = cubeCalculatorService.countPerimeter(cube);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "area-data-provider")
    public void testCountArea(Cube cube, double expected){
        double actual = cubeCalculatorService.countArea(cube);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "volume-data-provider")
    public void testCountVolume(Cube cube, double expected){
        double actual = cubeCalculatorService.countVolume(cube);
        Assert.assertEquals(actual, expected);
    }
}
