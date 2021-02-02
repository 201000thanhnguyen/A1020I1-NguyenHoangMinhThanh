package _7_Abstract_And_Interface._bai_tap;

public class Rectangle extends Shape implements Resizeable {
    private double width = 1;
    private double length = 1;

    public Rectangle(){};

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea(){
        return width * length;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width= " + width +
                ", length= " + length +
                ", area= " + getArea() +
                '}';
    }

    @Override
    public void resize(double percent) {
        this.width += (width * percent) / 100;
        this.length += (length * percent) / 100;
    }
}
