package _6_Ke_thua._bai_tap;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        c1.setColor("red");
        c1.setRadius(10);
        System.out.println(c1.toString());

        Cylinder c2 = new Cylinder(10, 5);
        System.out.println("Cylinder:"
                + " radius=" + c2.getRadius()
                + " height=" + c2.getHeight()
                + " base area=" + c2.getArea()
                + " volume=" + c2.getVolume());

    }
}
