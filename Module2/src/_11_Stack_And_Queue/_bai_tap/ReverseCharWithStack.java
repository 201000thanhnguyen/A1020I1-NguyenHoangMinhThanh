package _11_Stack_And_Queue._bai_tap;

import java.util.Stack;

public class ReverseCharWithStack {

    public static String ReverseString(String chuoi) {
        char[] charArray = chuoi.toCharArray();
        char[] charArrayNew = new char[charArray.length];

        Stack<Character> stackChar = new Stack<>();
        for (int i = 0; i < charArray.length; i++){
            stackChar.push(charArray[i]);
        }

        for (int i = 0; i < charArray.length; i++){
            charArrayNew[i] = stackChar.pop();
        }
        String result = new String(charArrayNew);

        return result;

    }
}
