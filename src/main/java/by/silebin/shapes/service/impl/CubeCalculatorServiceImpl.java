package by.silebin.shapes.service.impl;

import by.silebin.shapes.entity.Cube;
import by.silebin.shapes.entity.Dot;
import by.silebin.shapes.service.CubeCalculatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeCalculatorServiceImpl implements CubeCalculatorService {

    private static final Logger LOGGER = LogManager.getLogger(CubeCalculatorServiceImpl.class.getName());

    @Override
    public double countArea(Cube cube) {
        LOGGER.info("counting area");
        Dot a = cube.getA();
        Dot b = cube.getB();
        double side  = Math.abs(a.getX() - b.getX());
        double area  = 6 * Math.pow(side, 2);
        return area;
    }

    @Override
    public double countVolume(Cube cube) {
        LOGGER.info("counting volume");
        Dot a = cube.getA();
        Dot b = cube.getB();
        double side  = Math.abs(a.getX() - b.getX());
        double volume = Math.pow(side, 3);
        return volume;
    }

    @Override
    public double countPerimeter(Cube cube) {
        LOGGER.info("counting perimeter");
        Dot a = cube.getA();
        Dot b = cube.getB();
        double side  = Math.abs(a.getX() - b.getX());
        double perimeter = side * 12;
        return perimeter;
    }
}
