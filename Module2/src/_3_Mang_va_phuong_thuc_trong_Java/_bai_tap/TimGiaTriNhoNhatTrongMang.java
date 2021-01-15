package _3_Mang_va_phuong_thuc_trong_Java._bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ban muon mang co bao nhieu phan tu : ");
        int soPhanTu = scanner.nextInt();
        int[] mang = new int[soPhanTu];
        for (int i = 0; i < mang.length; i++){
            System.out.print("moi ban nhap phan tu thu "+(i+1)+" : ");
            mang[i] = scanner.nextInt();
        }
        int nhoNhat = mang[0];
        for (int j = 0; j < mang.length; j++){
            if (mang[j] < nhoNhat){
                nhoNhat = mang[j];
            }
        }
        System.out.println("so nho nhat trong mang la : "+nhoNhat);
    }
}
