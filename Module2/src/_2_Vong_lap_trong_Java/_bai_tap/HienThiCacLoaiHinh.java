package _2_Vong_lap_trong_Java._bai_tap;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        // cau 1
        for (int i = 1; i <= 5; i++){
            for (int j = 1; j <= 7; j++){
                System.out.print("* ");
            }
            System.out.println("*");
        }
        System.out.println();
        // cau 2
        for (int k = 0; k <= 5; k++){
            for (int l = 0; l <= k; l++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
        System.out.println();
        // cau 3
        for (int m = 6; m >= 1; m--){
            for (int n = 0; n < m; n++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
}
