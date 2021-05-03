package by.silebin.shapes.entity;

public class CubeParameters {
    private double area;
    private double volume;
    private double perimeter;

    public CubeParameters() {

    }

    public CubeParameters(double area, double volume, double perimeter) {
        this.area = area;
        this.volume = volume;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
}
