package _11_Stack_And_Queue._bai_tap;

import java.util.Arrays;
import java.util.Stack;

public class ReverseCharWithStack {

    public static String reverseChar(String str) {
        char[] charLength = str.toCharArray();
        char[] charNew = new char[charLength.length];
        Stack<Character> stackChar = new Stack<>();
        for (int i = charLength.length-1; i >= 0; i--){
            stackChar.push(charLength[i]);
            for (int j = 0; j < charLength.length; j++){
                if (j + i+1 == charLength.length){
                    charNew[j] = stackChar.get(j);
                }
            }
        }
        String stringNew = new String(charNew);
        return stringNew;
    }
}
