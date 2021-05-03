package by.silebin.shapes.comparator;

import by.silebin.shapes.entity.Cube;

import java.util.Comparator;

public class CubeIdComparator implements Comparator<Cube> {
    @Override
    public int compare(Cube o1, Cube o2) {
        long firstId = o1.getCubeId();
        long secondId = o2.getCubeId();
        return Long.compare(firstId, secondId);
    }
}
