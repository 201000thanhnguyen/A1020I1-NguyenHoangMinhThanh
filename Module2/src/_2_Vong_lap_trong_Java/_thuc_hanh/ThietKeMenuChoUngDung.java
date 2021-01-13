package _2_Vong_lap_trong_Java._thuc_hanh;

import java.util.Scanner;

public class ThietKeMenuChoUngDung {
    public static void main(String[] args) {
        int chon;
        boolean lap = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. hien thi ?an 1 ");
            System.out.println("2. hien thi ?an 2 ");
            System.out.println("3. thoat\n");

            System.out.print("moi ban lua chon : ");
            chon = scanner.nextInt();
            switch (chon) {
                case 1:
                    System.out.println("khong co gi de hien thi");
                    break;
                case 2:
                    System.out.println("ban dang doc dong` hien? thi do'");
                    break;
                case 3:
                    lap = false;
                    break;
                default:
                    break;
            }
        }while (lap == true);
    }
}
