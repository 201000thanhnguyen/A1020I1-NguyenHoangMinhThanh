package _1_Introduction_to_Java._thuc_hanh;

import java.util.Scanner;

public class GiaiBatPhuongTrinhBacNhat {
    public static void main(String[] args) {
        System.out.println("bat phuong trinh bac 1");
        System.out.println("a * x + b = 0, vui long nhap cac gia tri : ");

        Scanner giaTri = new Scanner(System.in);

        System.out.println("nhap a : ");
        double a = giaTri.nextDouble();

        System.out.println("nhap b : ");
        double b = giaTri.nextDouble();

        System.out.println("nhap c : ");
        double c = giaTri.nextDouble();

        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("Equation pass with x = %f!\n", answer);
        } else {
            if (b == 0) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }

    }
}
