package _3_Mang_va_phuong_thuc_trong_Java._bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mang1 = new int[] {1,2,3,4};
        int[] mang2 = new int[mang1.length - 1];
        System.out.println("mang cua ban la : ");
//        for (int i = 0; i < mang1.length; i++){
//            System.out.print(mang1[i] + " ");
//        }
        System.out.println(Arrays.toString(mang1));
        System.out.print("ban muon xoa phan tu thu : ");
        int ptMuonXoa = scanner.nextInt();
        for (int i = 0; i < mang1.length; i++)
        {
            if (i >= ptMuonXoa - 1)
            {
                if (i == mang1.length - 1)
                {
                    mang1[i] = 0;
                }
                else
                {
                    mang1[i] = mang1[i + 1];
                }
            }
        }
        for (int k = 0; k < mang2.length; k++)
        {
            mang2[k] = mang1[k];
        }
        System.out.println("mang sau khi xoa la : ");
//        for (int l = 0; l < mang2.length; l++)
//        {
//            System.out.print(mang2[l] + " ");
//        }
        System.out.println(Arrays.toString(mang2));
    }
}
