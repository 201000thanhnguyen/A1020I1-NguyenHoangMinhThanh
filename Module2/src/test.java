import java.util.Arrays;
import java.util.Scanner;

public class test {
    public final float HANGFLOAT = 3.14f;

    public static void main(String[] args) {
        test x = new test();
        float z = x.HANGFLOAT;
        System.out.println(z);
//        int[] mang1 = new int[] {1,2,3,4};
//        int a = 1, b = 2, c = 3;
//        int avg = Avg(mang1);
//        System.out.println("diem trung binh la : "+avg);
    }

    static int Avg(int[] mang){
        int sum = 0;
        for (var item : mang) {
            sum += item;
        }
        return (mang.length == 0) ? 0 : (sum / mang.length);
    }
}
