package _6_Ke_thua._bai_tap;

import java.util.Arrays;

public class Call {
    public static void main(String[] args) {
        MoveablePoint point1 = new MoveablePoint();
        point1.setX(5);
        point1.setY(10);
        point1.setXY(1,11);
        point1.setSpeed(5,5);
        System.out.println(Arrays.toString(point1.getXY()));
        System.out.println(point1.toString());
        System.out.println(point1.move());
    }
}
