package _1_Introduction_to_Java._bai_tap;

import java.util.Scanner;

public class HienThiLoiChao {
    public static void main(String[] args) {
        System.out.println("ten ban la : ");
        Scanner nhapTen = new Scanner(System.in);
        String hoTen = nhapTen.nextLine();
        System.out.printf("xin chao : %s", hoTen);
    }
}
