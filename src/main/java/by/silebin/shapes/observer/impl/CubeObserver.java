package by.silebin.shapes.observer.impl;

import by.silebin.shapes.entity.Cube;
import by.silebin.shapes.entity.CubeParameters;
import by.silebin.shapes.observer.CubeEvent;
import by.silebin.shapes.observer.Observer;
import by.silebin.shapes.service.CubeCalculatorService;
import by.silebin.shapes.service.impl.CubeCalculatorServiceImpl;
import by.silebin.shapes.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeObserver implements Observer {

    private static final Logger LOGGER = LogManager.getLogger(CubeObserver.class.getName());

    @Override
    public void parameterChanged(CubeEvent cubeEvent) {
        LOGGER.info("parameter changed, calculating new warehouse data");
        Cube cube = cubeEvent.getSource();
        long id = cube.getCubeId();
        //get parameters
        //calculate service data
        CubeCalculatorService cubeCalculatorService = new CubeCalculatorServiceImpl();

        double perimeter = cubeCalculatorService.countPerimeter(cube);
        double volume = cubeCalculatorService.countVolume(cube);
        double area = cubeCalculatorService.countArea(cube);

        CubeParameters cubeParameters = new CubeParameters(area, volume, perimeter);
        //get instance warehouse
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.save(id, cubeParameters);
        //put data by id
    }
}
