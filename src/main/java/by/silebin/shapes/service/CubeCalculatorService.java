package by.silebin.shapes.service;

import by.silebin.shapes.entity.Cube;

public interface CubeCalculatorService {
    double countArea(Cube cube);
    double countVolume(Cube cube);
    double countPerimeter(Cube cube);
}
