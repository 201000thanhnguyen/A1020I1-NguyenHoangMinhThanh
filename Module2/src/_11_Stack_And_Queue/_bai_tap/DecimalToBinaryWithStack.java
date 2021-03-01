package _11_Stack_And_Queue._bai_tap;

import java.util.Stack;

public class DecimalToBinaryWithStack {

    public static String DecimalToBinary(int inputInt) {
        int saveInt = inputInt;
        String newString = "";
        Stack<Integer> stackInt = new Stack<>();
        while (inputInt != 0){
            int d = inputInt % 2;
            stackInt.push(d);
            inputInt /= 2;
        }

        System.out.print(saveInt + " Decimal = ");
        while (!(stackInt.isEmpty())){
            newString += stackInt.pop();
        }
        newString += " Binary";
        return newString;
    }
}
