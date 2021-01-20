package _3_Mang_va_phuong_thuc_trong_Java._bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class TinhTongCacSoOCotXacDinh {
    public static void main(String[] args) {
        System.out.print("ban muon co bao nhieu mang : ");
        Scanner scanner = new Scanner(System.in);
        int soMang = scanner.nextInt();
        System.out.print("ban muon moi mang bao nhieu phan tu : ");
        int soPhanTu = scanner.nextInt();

        int[][] mang = new int[soMang][soPhanTu];
        for (int i = 0; i < mang.length; i++){
            System.out.println("moi ban nhap cac phan tu mang "+(i+1)+" : ");
            for (int j = 0; j < mang[i].length; j++){
                System.out.print("moi ban nhap phan tu thu "+(j+1)+" : ");
                mang[i][j] = scanner.nextInt();
            }
        }
        System.out.println("bang cua ban la ");
        for (int k = 0; k < mang.length; k++){
            for (int l = 0; l < mang[k].length; l++){
                System.out.print(mang[k][l] + "\t");
            }
            System.out.println();
        }
        System.out.print("ban muon tinh tong cot thu : ");
        int cotThu = scanner.nextInt();
        int tongLa = 0;
        System.out.print("\ncot thu "+cotThu+" ket qua la : ");
        cotThu -= 1;
        String kq = "";
        for (int m = 0; m < mang.length; m++){
            for (int n = 0; n < mang[m].length; n++){
                if (n == cotThu){
                    kq += mang[m][n] + " + ";
                    tongLa += mang[m][n];
                }
            }
        }
        kq = kq.substring(0, kq.length()-2) + "= "+tongLa;
        System.out.println(kq);
    }
}
