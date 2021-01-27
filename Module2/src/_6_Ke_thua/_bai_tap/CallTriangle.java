package _6_Ke_thua._bai_tap;

public class CallTriangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3,4,5);
        System.out.println(triangle.toString());

        Triangle triangle1 = new Triangle(2,4,6,"black",false);
        System.out.println(triangle1.toString());
    }
}
