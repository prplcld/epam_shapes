package by.silebin.shapes.comparator;

import by.silebin.shapes.entity.Cube;

import java.util.Comparator;

public class CubeFirstPointXComparator implements Comparator<Cube> {
    @Override
    public int compare(Cube o1, Cube o2) {
        double firstPointX = o1.getC().getX();
        double secondPointX = o2.getC().getX();
        return Double.compare(firstPointX, secondPointX);
    }
}
