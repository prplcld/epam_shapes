package by.silebin.shapes.factory;

import by.silebin.shapes.entity.Cube;
import by.silebin.shapes.entity.Dot;
import by.silebin.shapes.exception.CubeFactoryException;
import by.silebin.shapes.exception.ShapeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeFactory {

    private static final Logger LOGGER = LogManager.getLogger(CubeFactory.class.getName());

    public Cube createCube(double... coordinates) throws CubeFactoryException {
        if (coordinates.length != 24) {
            LOGGER.error("not enough parameters for creating cube");
            throw new CubeFactoryException("not enough parameters for creating cube");
        }

        Dot[] dots = new Dot[8];
        for (int i = 0; i < 8; i++) {
            dots[i] = new Dot(coordinates[i * 3], coordinates[i * 3 + 1], coordinates[i * 3 + 2]);
        }
        return createCube(dots);
    }

    public Cube createCube(Dot... dots) throws CubeFactoryException {
        if (dots.length != 8) {
            LOGGER.error("not enough parameters for creating cube");
            throw new CubeFactoryException("not enough parameters for creating cube");
        }
        Cube cube = null;
        try {
            cube = new Cube(dots[0], dots[1], dots[2], dots[3], dots[4], dots[5], dots[6], dots[7]);
        } catch (ShapeException e) {
            LOGGER.error(e);
        }
        return cube;
    }
}
