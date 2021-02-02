package _7_Abstract_And_Interface._bai_tap;

public class Circle extends Shape implements Resizeable {
    private double radius = 1;

    public Circle(){};

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius= " + radius +
                ", area= " + getArea() +
                '}';
    }

    @Override
    public void resize(double percent) {
        this.radius += (radius * percent) / 100;
    }
}
