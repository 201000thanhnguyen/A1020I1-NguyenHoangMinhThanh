package _2_Vong_lap_trong_Java._thuc_hanh;

import java.util.*;

public class UngDungTinhTienLaiChoVay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float kq = 0;
        double tienGui = 1.0;
        int thangGui = 1;
        double laiXuat = 1.0;

        System.out.println("nhap so tien gui : ");
        tienGui = scanner.nextDouble();

        System.out.println("nhap so thang gui : ");
        thangGui = scanner.nextInt();

        System.out.println("nhap lai xuat : ");
        laiXuat = scanner.nextDouble();

        double laiNhanDuoc = 0;
        for (int i = 0; i < thangGui; i++){
            laiNhanDuoc = tienGui * (laiXuat / 100) / 12 * thangGui;
            kq = Math.round(laiNhanDuoc);
        }
        System.out.println("tong lai nhan duoc : "+ kq);
    }
}
