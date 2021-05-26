package by.silebin.shapes.comparator;

import by.silebin.shapes.entity.Cube;

import java.util.Comparator;

public class CubeFirstPointYComparator implements Comparator<Cube> {
    @Override
    public int compare(Cube o1, Cube o2) {
        double firstPointY = o1.getC().getY();
        double secondPointY = o2.getC().getY();
        return Double.compare(firstPointY, secondPointY);
    }
}
