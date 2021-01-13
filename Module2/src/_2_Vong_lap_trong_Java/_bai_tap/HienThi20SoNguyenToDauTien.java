package _2_Vong_lap_trong_Java._bai_tap;

import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ban muon hien thi bao nhieu so nguyen to dau tien : ");
        System.out.println("toi da 20 so dau tien");
        int nhapSo = scanner.nextInt();
        int dem = 1;
        int demSoLan = 1;
        int stt = 1;
        if (nhapSo <= 20){
            for (int i = 1; dem <= nhapSo; i++)
            {
                for (int j = 1; j <= i; j++)
                {
                    if (i % j == 0)
                    {
                        demSoLan += 1;
                    }
                }
                if (demSoLan < 3 && i != 1)
                {
                    System.out.println("day la so nguyen to thu "+stt+" : "+i);
                    demSoLan = 0;
                    dem++;
                    stt++;
                }
                else
                {
                    demSoLan = 0;
                }
            }
        }else {
            System.out.println("ban da nhap qua gioi han");
        }
    }
}
