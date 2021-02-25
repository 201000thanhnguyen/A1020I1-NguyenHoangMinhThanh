package _11_Stack_And_Queue._bai_tap;

import java.util.Stack;

public class ReverseArrayWithStack {

    public static int[] reverseArray(int[] arrInt) {
        int[] arrNew = new int[arrInt.length];
        Stack<Integer> stackInt = new Stack<>();
        for (int i = arrInt.length-1; i >= 0; i--){
            stackInt.push(arrInt[i]);
            for (int j = 0; j < arrInt.length; j++){
                if (j + i+1 == arrInt.length){
                    arrNew[j] = stackInt.get(j);
                }
            }
        }
        return arrNew;
    }
}
