package by.silebin.shapes.repository;

import by.silebin.shapes.entity.Cube;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CubeRepository {

    private static CubeRepository instance;

    public static CubeRepository getInstance() {
        if(instance == null){
            instance = new CubeRepository();
        }
        return instance;
    }

    private List<Cube> cubes;

    private CubeRepository() {
        cubes = new ArrayList<>();
    }

    public boolean add(Cube cube) {
        return cubes.add(cube);
    }

    public boolean remove(Cube o) {
        return cubes.remove(o);
    }

    public boolean addAll(Collection<? extends Cube> c) {
        return cubes.addAll(c);
    }

    public boolean removeAll(Collection<Cube> c) {
        return cubes.removeAll(c);
    }

    public Cube get(int index) {
        return cubes.get(index);
    }

    public Cube set(int index, Cube element) {
        return cubes.set(index, element);
    }

    public List<Cube> getCubes() {
        return List.copyOf(cubes);
    }

    public List<Cube> sort(Comparator<? super Cube> c){
        return cubes.stream()
                .sorted(c)
                .collect(Collectors.toList());
    }

    public List<Cube> query(Specification specification){
        List<Cube> result = cubes.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
        return result;
    }
}
