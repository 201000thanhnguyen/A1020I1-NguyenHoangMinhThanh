package _5_Access_modifier._bai_tap;

public class AccessModifier {
    private double radius = 1.0;
    private String color = "red";

    public AccessModifier() {

    }

    public double AccessModifier(double radius){
        return this.radius = radius;
    }

    protected double getRadius() {
        return radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }
}
