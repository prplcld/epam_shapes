package by.silebin.shapes.entity;

import by.silebin.shapes.exception.ShapeException;
import by.silebin.shapes.observer.CubeEvent;
import by.silebin.shapes.observer.Observable;
import by.silebin.shapes.observer.Observer;
import by.silebin.shapes.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Cube implements Observable {

    private static final Logger LOGGER = LogManager.getLogger(Cube.class.getName());

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

    public Cube(Dot a, Dot b, Dot c, Dot d, Dot e, Dot f, Dot g, Dot h) throws ShapeException {
        if (a == null || b == null || c == null || d == null || e == null || f == null || g == null || h == null) {
            LOGGER.error("can't create cube from given parameters");
            throw new ShapeException("can't create cube");
        }
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

    public void setA(Dot a) throws ShapeException {
        if (a == null) {
            LOGGER.error("can't create cube from given parameters");
            throw new ShapeException();
        }
        this.a = a;
        notifyObservers();
    }

    public Dot getB() {
        return b;
    }

    public void setB(Dot b) throws ShapeException {
        if (b == null) {
            LOGGER.error("can't create cube from given parameters");
            throw new ShapeException();
        }
        this.b = b;
        notifyObservers();
    }

    public Dot getC() {
        return c;
    }

    public void setC(Dot c) throws ShapeException {
        if (c == null) {
            LOGGER.error("can't create cube from given parameters");
            throw new ShapeException();
        }
        this.c = c;
        notifyObservers();
    }

    public Dot getD() {
        return d;
    }

    public void setD(Dot d) throws ShapeException {
        if (d == null) {
            LOGGER.error("can't create cube from given parameters");
            throw new ShapeException();
        }
        this.d = d;
        notifyObservers();
    }

    public Dot getE() {
        return e;
    }

    public void setE(Dot e) throws ShapeException {
        if (e == null) {
            LOGGER.error("can't create cube from given parameters");
            throw new ShapeException();
        }
        this.e = e;
        notifyObservers();
    }

    public Dot getF() {
        return f;
    }

    public void setF(Dot f) throws ShapeException {
        if (f == null) {
            LOGGER.error("can't create cube from given parameters");
            throw new ShapeException();
        }
        this.f = f;
        notifyObservers();
    }

    public Dot getG() {
        return g;
    }

    public void setG(Dot g) throws ShapeException {
        if (g == null) {
            LOGGER.error("can't create cube from given parameters");
            throw new ShapeException();
        }
        this.g = g;
        notifyObservers();
    }

    public Dot getH() {
        return h;
    }

    public void setH(Dot h) throws ShapeException {
        if (h == null) {
            LOGGER.error("can't create cube from given parameters");
            throw new ShapeException();
        }
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

    @Override
    public String toString() {
        return "Cube{" +
                "cubeId=" + cubeId +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                ", f=" + f +
                ", g=" + g +
                ", h=" + h +
                ", observers=" + observers +
                '}';
    }
}
