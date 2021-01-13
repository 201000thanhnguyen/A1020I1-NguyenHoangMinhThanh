package _2_Vong_lap_trong_Java._thuc_hanh;

import java.util.Scanner;

public class TimUCLNCuaAVaBb {
    public static void main(String[] args) {
        int a, b;
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap a : ");
        a = scanner.nextInt();

        System.out.print("nhap b : ");
        b = scanner.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0){
            System.out.print("khong co uoc chung lon nhat");
        }else {
            while (a != b) {
                if (a > b)
                    a = a - b;
                else
                    b = b - a;
            }
            System.out.print("Uoc chung lon nhat la : " + a);
        }

    }
}
