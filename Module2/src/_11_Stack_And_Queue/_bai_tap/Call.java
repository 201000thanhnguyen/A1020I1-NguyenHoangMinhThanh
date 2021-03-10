package _11_Stack_And_Queue._bai_tap;

import java.util.*;

public class Call {
    public static void main(String[] args) {
//        String testString1 = "abc x abc";
//        String testString2 = "abc x cba";
//        System.out.println(PalindromeWithQueue.isSymmetry(testString1));
//        System.out.println(PalindromeWithQueue.isSymmetry(testString2));
//
//        System.out.println(ReverseCharWithStack.ReverseString(testString2));

        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(1,"alo1");
        testMap.put(2,"alo2");
        Collection<String> testCollection = testMap.values();
        testCollection.forEach(x -> System.out.println(x));

        String testE = new String(String.valueOf(testMap));
        System.out.println(testE);

        System.out.println(testMap.keySet());
        Set<Integer> testSet = testMap.keySet();
        testSet.forEach(x -> System.out.println(x));
        
    }
}
