package _11_Stack_And_Queue._bai_tap;

import java.util.Arrays;
import java.util.Stack;

public class ReverseCharWithStack {

    public static String reverseChar(String str) {
        char[] charNew = str.toCharArray();
        Stack<Character> stackChar = new Stack<>();
        for (int i = charNew.length-1; i >= 0; i--){
            stackChar.push(charNew[i]);
            for (int j = 0; j < charNew.length; j++){
                if (j + i+1 == charNew.length){
                    charNew[j] = stackChar.get(j);
                }
            }
        }
        return "chưa xong :V";
    }

    public static void main(String[] args) {
        String chuoi = "a bc def";
        char[] test_arr = chuoi.toCharArray();

        Stack<Character> stackChar = new Stack<>();



        String a = new String(test_arr);
        System.out.println(a);
        System.out.println(Arrays.toString(test_arr));
    }
}
