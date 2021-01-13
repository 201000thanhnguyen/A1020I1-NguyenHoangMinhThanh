package _2_Vong_lap_trong_Java._bai_tap;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        int dem = 1, demSoLan = 1, stt = 1;
        for (int i = 1; i <= 100; i++)
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
    }
}
