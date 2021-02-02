package _7_Abstract_And_Interface._bai_tap;

public class Square extends Rectangle implements Colorable {

    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public double getSide(){
        return getWidth();
    }

    public void setSide(double side){
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides...");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
