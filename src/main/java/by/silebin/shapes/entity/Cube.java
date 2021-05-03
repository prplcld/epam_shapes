package by.silebin.shapes.entity;

import by.silebin.shapes.observer.CubeEvent;
import by.silebin.shapes.observer.Observable;
import by.silebin.shapes.observer.Observer;
import by.silebin.shapes.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cube implements Observable {

    private long cubeId;
    private Dot a;
    private Dot b;
    private Dot c;
    private Dot d;
    private Dot e;
    private Dot f;
    private Dot g;
    private Dot h;

    private List<Observer> observers = new ArrayList<>();

    public Cube() {
    }

    public Cube(Dot a, Dot b, Dot c, Dot d, Dot e, Dot f, Dot g, Dot h) {
        this.cubeId = IdGenerator.generateId();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        notifyObservers();
    }

    public long getCubeId() {
        return cubeId;
    }

    public void setCubeId(long cubeId) {
        this.cubeId = cubeId;
        notifyObservers();
    }

    public Dot getA() {
        return a;
    }

    public void setA(Dot a) {
        this.a = a;
        notifyObservers();
    }

    public Dot getB() {
        return b;
    }

    public void setB(Dot b) {
        this.b = b;
        notifyObservers();
    }

    public Dot getC() {
        return c;
    }

    public void setC(Dot c) {
        this.c = c;
        notifyObservers();
    }

    public Dot getD() {
        return d;
    }

    public void setD(Dot d) {
        this.d = d;
        notifyObservers();
    }

    public Dot getE() {
        return e;
    }

    public void setE(Dot e) {
        this.e = e;
        notifyObservers();
    }

    public Dot getF() {
        return f;
    }

    public void setF(Dot f) {
        this.f = f;
        notifyObservers();
    }

    public Dot getG() {
        return g;
    }

    public void setG(Dot g) {
        this.g = g;
        notifyObservers();
    }

    public Dot getH() {
        return h;
    }

    public void setH(Dot h) {
        this.h = h;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return a.equals(cube.a) && b.equals(cube.b) && c.equals(cube.c) && d.equals(cube.d) && e.equals(cube.e) && f.equals(cube.f) && g.equals(cube.g) && h.equals(cube.h);
    }

    @Override
    public int hashCode() {
        int result = 0;
        result += a.hashCode() + b.hashCode() + c.hashCode() + d.hashCode() + e.hashCode() + f.hashCode() + g.hashCode() + h.hashCode();
        return result;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        CubeEvent event = new CubeEvent(this);
        observers.forEach(o -> o.parameterChanged(event));
    }
}
