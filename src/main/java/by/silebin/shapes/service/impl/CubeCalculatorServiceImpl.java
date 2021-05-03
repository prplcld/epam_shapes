package by.silebin.shapes.service.impl;

import by.silebin.shapes.entity.Cube;
import by.silebin.shapes.entity.Dot;
import by.silebin.shapes.service.CubeCalculatorService;

public class CubeCalculatorServiceImpl implements CubeCalculatorService {
    @Override
    public double countArea(Cube cube) {
        Dot a = cube.getA();
        Dot b = cube.getB();
        double side  = Math.abs(a.getX() - b.getX());
        double area  = 6 * Math.pow(side, 2);
        return area;
    }

    @Override
    public double countVolume(Cube cube) {
        Dot a = cube.getA();
        Dot b = cube.getB();
        double side  = Math.abs(a.getX() - b.getX());
        double volume = Math.pow(side, 3);
        return volume;
    }

    @Override
    public double countPerimeter(Cube cube) {
        Dot a = cube.getA();
        Dot b = cube.getB();
        double side  = Math.abs(a.getX() - b.getX());
        double perimeter = side * 12;
        return perimeter;
    }
}
