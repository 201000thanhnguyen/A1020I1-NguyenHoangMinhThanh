package _11_Stack_And_Queue._bai_tap;

import java.util.Arrays;

public class Call {
    public static void main(String[] args) {
        int[] mangTesst = new int[]{1,2,3,4};
        mangTesst = ReverseArrayWithStack.reverseArray(mangTesst);
        System.out.println(Arrays.toString(mangTesst));
    }
}
