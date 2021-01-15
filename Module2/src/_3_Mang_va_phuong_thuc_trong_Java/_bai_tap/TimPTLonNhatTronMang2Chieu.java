package _3_Mang_va_phuong_thuc_trong_Java._bai_tap;

import java.util.Scanner;

public class TimPTLonNhatTronMang2Chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int[][] mang2Chieu = new int[2][4];
        for (int j = 0; j < mang2Chieu.length; j++){
            System.out.println("moi ban nhap cac phan tu cua mang thu : "+(j+1));
            for (int k = 0; k < mang2Chieu[j].length; k++){
                System.out.print("nhap phan tu thu "+(k+1)+" : ");
                mang2Chieu[j][k] = scanner.nextInt();
            }
        }

        for (int i = 0; i < mang2Chieu.length; i++){
            for (int j = 0; j < mang2Chieu[i].length; j++){
                if (max < mang2Chieu[i][j]){
                    max = mang2Chieu[i][j];
                }
            }
        }
        System.out.println("\nso lon nhat trong mang 2 chieu la : "+max);
    }
}
