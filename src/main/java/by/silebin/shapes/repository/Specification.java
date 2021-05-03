package by.silebin.shapes.repository;

import by.silebin.shapes.entity.Cube;

public interface Specification<T> {

    boolean specify(T object);
}
