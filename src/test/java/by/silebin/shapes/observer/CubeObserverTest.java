package by.silebin.shapes.observer;

import by.silebin.shapes.entity.Cube;
import by.silebin.shapes.entity.CubeParameters;
import by.silebin.shapes.entity.Dot;
import by.silebin.shapes.exception.ShapeException;
import by.silebin.shapes.observer.impl.CubeObserver;
import by.silebin.shapes.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CubeObserverTest {

    private static final Dot[] dots;
    private Warehouse warehouse;
    private Cube cube = new Cube(dots[0], dots[1], dots[2], dots[3], dots[4], dots[5], dots[6], dots[7]);
    private static final CubeParameters expected = new CubeParameters(24, 8, 24);

    static {
        dots = new Dot[8];
        dots[0] = new Dot(0, 0, 1);
        dots[1] = new Dot(1, 0, 1);
        dots[2] = new Dot(1, 1, 1);
        dots[3] = new Dot(0, 1, 1);
        dots[4] = new Dot(0, 0, 0);
        dots[5] = new Dot(1, 0, 0);
        dots[6] = new Dot(1, 1, 0);
        dots[7] = new Dot(0, 1, 0);
    }

    public CubeObserverTest() throws ShapeException {
    }

    @BeforeTest
    public void init() {
        warehouse = Warehouse.getInstance();
        cube.attach(new CubeObserver());
    }

    @Test
    public void testParameterChanged() throws ShapeException {
        cube.setB(new Dot(2, 0, 1));
        CubeParameters actual = warehouse.get(cube.getCubeId());
        Assert.assertEquals(actual, expected);
    }
}
