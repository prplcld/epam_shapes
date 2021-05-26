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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeParameters that = (CubeParameters) o;
        return Double.compare(that.area, area) == 0 && Double.compare(that.volume, volume) == 0 && Double.compare(that.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += Double.hashCode(area) + Double.hashCode(volume) + Double.hashCode(perimeter);
        return result;
    }
}
