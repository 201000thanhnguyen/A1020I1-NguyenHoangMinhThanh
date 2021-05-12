package _3_Mang_va_phuong_thuc_trong_Java._bai_tap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mang1 = new int[] {1,2,3,4};
        int[] mang2 = new int[mang1.length + 1];
        int viTri;
        int nhapSo;

        System.out.println("mang cua ban la : ");
        for (int i = 0; i < mang1.length; i++){
            System.out.print(mang1[i] + " ");
        }
        System.out.print("\nban muon chen so : ");
        nhapSo = scanner.nextInt();
        System.out.print("ban muon chen them phan tu vao vi tri thu : ");
        viTri = scanner.nextInt();

        for (int j = 0; j < mang2.length; j++){
            if (j < viTri - 1){
                mang2[j] = mang1[j];
            }
            if (j == viTri - 1){
                for (int l = viTri - 1; l < mang2.length; l++){
                    if (l == j){
                        mang2[l] = nhapSo;
                    }
                }
            }
            if (j >= viTri - 1){
                if (j < mang1.length){
                    mang2[j + 1] = mang1[j];
                }
            }
        }
        System.out.println("mang cua ban la : ");
        for (int item : mang2 ) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
