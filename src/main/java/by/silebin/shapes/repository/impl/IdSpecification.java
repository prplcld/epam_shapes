package by.silebin.shapes.repository.impl;

import by.silebin.shapes.entity.Cube;
import by.silebin.shapes.repository.Specification;

public class IdSpecification implements Specification<Cube> {

    private long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Cube object) {
        if(object == null) {
            return false;
        }
        else {
            return object.getCubeId() == id;
        }
    }
}
