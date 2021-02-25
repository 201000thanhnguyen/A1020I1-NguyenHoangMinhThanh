package _11_Stack_And_Queue._bai_tap;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Call {
    public static void main(String[] args) {
        int[] mangTesst = new int[]{1,2,3,4,9};
        mangTesst = ReverseArrayWithStack.reverseArray(mangTesst);
        System.out.println(Arrays.toString(mangTesst));

        String chuoiString = "abc zyx bd 3d";
        System.out.println(
                chuoiString = ReverseCharWithStack.reverseChar(chuoiString)
        );
    }
}
