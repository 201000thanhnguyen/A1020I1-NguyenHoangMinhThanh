package _3_Mang_va_phuong_thuc_trong_Java._thuc_hanh;

import java.util.Scanner;

public class UngDungDemSoLuongSinhVienThiDo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nban muon nhap bao nhieu sinh vien : ");
        int soLuongSinhVien = scanner.nextInt();

        String[] tenSinhVien = new String[soLuongSinhVien];
        int[] diemSinhVien = new int[soLuongSinhVien];
        scanner.skip("\\R");

        for (int i = 0; i < soLuongSinhVien; i++){
            System.out.print("nhap ten sinh vien thu "+(i+1)+" : ");
            tenSinhVien[i] = scanner.nextLine();
            System.out.print("diem : ");
            diemSinhVien[i] = scanner.nextInt();
            scanner.skip("\\R");
        }
        int demSoLuongThiDo = 0;
        System.out.println("\ncac sinh vien thi do la : ");
        for (int j = 0; j < soLuongSinhVien; j++){
            if (diemSinhVien[j] >= 5){
                System.out.println("sinh vien "+tenSinhVien[j]+" diem "+diemSinhVien[j]+";");
                demSoLuongThiDo += 1;
            }
        }
        System.out.println("tong co "+demSoLuongThiDo+" sinh vien thi do;");
    }
}
