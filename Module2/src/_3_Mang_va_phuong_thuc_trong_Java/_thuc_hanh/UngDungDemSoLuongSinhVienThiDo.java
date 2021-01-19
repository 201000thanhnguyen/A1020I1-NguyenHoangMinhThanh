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
            System.out.print("nhap diem sinh vien thu "+(i+1)+" : ");
            diemSinhVien[i] = scanner.nextInt();
            scanner.skip("\\R");
        }
    }
}
