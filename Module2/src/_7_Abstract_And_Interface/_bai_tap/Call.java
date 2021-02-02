package _7_Abstract_And_Interface._bai_tap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Call {
    public static void main(String[] args) {
        Resizeable resizeable = new Circle();
        Resizeable resizeable1 = new Rectangle();
        Resizeable resizeable2 = new Rectangle(2,3);
        Resizeable resizeable3 = new Square(4);

        List<Resizeable> list = new ArrayList<Resizeable>();
        list.add(resizeable);
        list.add(resizeable1);
        list.add(resizeable2);
        list.add(resizeable3);

        Random random = new Random();
        for (var item: list) {
            if (item instanceof Circle){
                Circle circle = (Circle)item;
                System.out.println("(truoc) dien tich "+circle.getClass().getSimpleName()+" : "+circle.getArea());
                circle.resize(random.nextInt(100));
                System.out.println("(sau) dien tich "+circle.getClass().getSimpleName()+" : "+circle.getArea());
            }else if (item instanceof Colorable){
                Square square = (Square)item;
                square.setSide(2);
                System.out.println("dien tich "+square.getClass().getSimpleName()+" : " + square.getArea());
                square.howToColor();
            }
        }
    }
}
