package _3_Mang_va_phuong_thuc_trong_Java._bai_tap;

public class GopMang {
    public static void main(String[] args) {
        int[] mang1 = new int[] {1,2,3,4};
        int[] mang2 = new int[] {5,6,7,8,9};
        int[] mang3 = new int[mang1.length + mang2.length];

        for (int i = 0; i < mang1.length; i++){
            mang3[i] = mang1[i];
        }
        for (int j = 0; j < mang2.length; j++){
            mang3[mang1.length + j] = mang2[j];
        }
        System.out.println("mang sau khi gop la : ");
        for (int k = 0; k < mang3.length; k++){
            System.out.print(mang3[k] + " ");
        }

    }
}
