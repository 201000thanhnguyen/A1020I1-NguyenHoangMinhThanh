package _1_Introduction_to_Java._thuc_hanh;

import java.util.Scanner;

public class SuDungToanTu {
    public static void main(String[] args) {
        float chieuDai, chieuRong;

        Scanner nhapDuLieu = new Scanner(System.in);

        System.out.println("nhap chieu dai : ");
        chieuDai = nhapDuLieu.nextFloat();

        System.out.println("nhap chieu rong : ");
        chieuRong = nhapDuLieu.nextFloat();

        float  dienTich = chieuDai * chieuRong;
        System.out.println("dien tich la : " +dienTich);

    }
}
