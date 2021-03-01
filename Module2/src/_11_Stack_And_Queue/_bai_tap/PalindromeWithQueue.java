package _11_Stack_And_Queue._bai_tap;

import java.util.LinkedList;
import java.util.Queue;

public class PalindromeWithQueue {

    public static String isSymmetry(String str1) {
        char[] arrChar1 = str1.toCharArray();
        char[] arrChar2 = new char[arrChar1.length];
        Queue<Character> characterQueue = new LinkedList<>();
        for (int i = 0; i < arrChar1.length; i++){
            characterQueue.add(arrChar1[i]);
        }

        for (int i = arrChar2.length-1; i >= 0;i--){
            arrChar2[i] = characterQueue.poll();
        }

        String str2 = new String(arrChar2);
        if (str1.equals(str2)){
            return "symmetry";
        }else {
            return "not symmetry";
        }
    }
}
