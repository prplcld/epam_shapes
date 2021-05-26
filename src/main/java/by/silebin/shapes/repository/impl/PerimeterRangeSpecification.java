package by.silebin.shapes.repository.impl;

import by.silebin.shapes.entity.Cube;
import by.silebin.shapes.repository.Specification;
import by.silebin.shapes.service.CubeCalculatorService;
import by.silebin.shapes.service.impl.CubeCalculatorServiceImpl;

public class PerimeterRangeSpecification implements Specification<Cube> {

    private double min;
    private double max;

    public PerimeterRangeSpecification(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specify(Cube object) {
        CubeCalculatorService cubeCalculatorService = new CubeCalculatorServiceImpl();

        double perimeter = cubeCalculatorService.countPerimeter(object);

        boolean result = perimeter < max && perimeter > min;
        return result;
    }
}
