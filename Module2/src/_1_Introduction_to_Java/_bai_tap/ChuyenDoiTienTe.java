package _1_Introduction_to_Java._bai_tap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        System.out.println("nhap gia tri usd : ");
        Scanner scanner = new Scanner(System.in);
        usd = scanner.nextDouble();
        double quyDoi = usd * vnd;
        System.out.printf("gia tri quy doi sang vnd la : %f",quyDoi);
    }
}
