package by.silebin.shapes.repository;

import by.silebin.shapes.comparator.CubeFirstPointXComparator;
import by.silebin.shapes.comparator.CubeFirstPointYComparator;
import by.silebin.shapes.comparator.CubeIdComparator;
import by.silebin.shapes.entity.Cube;
import by.silebin.shapes.entity.Dot;
import by.silebin.shapes.exception.ShapeException;
import by.silebin.shapes.repository.impl.FirstDotSpecification;
import by.silebin.shapes.repository.impl.IdSpecification;
import by.silebin.shapes.repository.impl.PerimeterRangeSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CubeRepositoryTest {
    private CubeRepository cubeRepository;
    private Cube cube1;
    private Cube cube2;
    private Cube cube3;

    private static final Dot[] dots;
    private static final Dot[] dots1;
    private static final Dot[] dots2;

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

        dots2 = new Dot[8];
        dots2[0] = new Dot(0, 0, 3);
        dots2[1] = new Dot(3, 0, 3);
        dots2[2] = new Dot(3, 3, 3);
        dots2[3] = new Dot(0, 3, 3);
        dots2[4] = new Dot(0, 0, 0);
        dots2[5] = new Dot(3, 0 , 0);
        dots2[6] = new Dot(3, 3, 0);
        dots2[7] = new Dot(0, 3, 0);
    }

    @BeforeTest
    public void init() throws ShapeException {
        cubeRepository = CubeRepository.getInstance();
        cube1 = new Cube(dots[0], dots[1], dots[2], dots[3], dots[4], dots[5], dots[6], dots[7]);
        cube2 = new Cube(dots1[0], dots1[1], dots1[2], dots1[3], dots1[4], dots1[5], dots1[6], dots1[7]);
        cube3  = new Cube(dots2[0], dots2[1], dots2[2], dots2[3], dots2[4], dots2[5], dots2[6], dots2[7]);
        cubeRepository.add(cube3);
        cubeRepository.add(cube1);
        cubeRepository.add(cube2);
    }

    @DataProvider(name = "query-data-provider")
    public Object[][] specificationProvider() throws ShapeException {
        return new Object[][] {
                {new IdSpecification(1), new Cube[]{cube2}},
                {new PerimeterRangeSpecification(0, 20), new Cube[]{cube1}},
                {new FirstDotSpecification(new Dot(0, 0, 0)), new Cube[]{cube3, cube1, cube2}}
        };
    }

    @DataProvider(name = "comparator-data-provider")
    public Object[][] comparatorProvider(){
        return new Object[][]{
                {new CubeIdComparator(), new Cube[]{cube1, cube2, cube3}},
                {new CubeFirstPointXComparator(), new Cube[]{cube1, cube2, cube3}},
                {new CubeFirstPointYComparator(), new Cube[]{cube1, cube2, cube3}}
        };
    }

    @Test(dataProvider = "query-data-provider")
    public void testQuery(Specification<Cube> specification, Cube[] cubes){
        List<Cube> actual = cubeRepository.query(specification);
        List<Cube> expected = Arrays.stream(cubes).collect(Collectors.toList());
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "comparator-data-provider")
    public void testSort(Comparator<Cube> comparator, Cube[] cubes){
        List<Cube> actual = cubeRepository.sort(comparator);
        List<Cube> expected = Arrays.stream(cubes).collect(Collectors.toList());
        Assert.assertEquals(actual, expected);
    }
}
