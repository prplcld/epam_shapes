package by.silebin.shapes.repository.impl;

import by.silebin.shapes.entity.Cube;
import by.silebin.shapes.entity.Dot;
import by.silebin.shapes.repository.Specification;

public class FirstDotSpecification implements Specification<Cube> {

    private Dot dot;

    public FirstDotSpecification(Dot dot) {
        this.dot = dot;
    }

    @Override
    public boolean specify(Cube object) {
        return dot.equals(object.getE());
    }
}
