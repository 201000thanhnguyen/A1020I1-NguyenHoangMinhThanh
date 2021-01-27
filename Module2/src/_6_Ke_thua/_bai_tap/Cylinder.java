package _6_Ke_thua._bai_tap;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(){
        super();
        height = 1.0;
    }

    public Cylinder(double height){
        super();
        this.height = height;
    }

    public Cylinder(double radius, double height){
        super(radius);
        this.height = height;
    }

    public double getHeight(){
        return height;
    }

    public double getVolume(){
        return getArea()*height;
    }

    @Override
    public String toString() {
        return "Cylinder:"
                + " radius=" + this.getRadius()
                + " height=" + this.getHeight()
                + " base area=" + this.getArea()
                + " volume=" + this.getVolume();
    }
}
