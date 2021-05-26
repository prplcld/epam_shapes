package by.silebin.shapes.repository;

public interface Specification<T> {

    boolean specify(T object);
}
