package _11_Stack_And_Queue._bai_tap;

import java.util.*;

public class CheckStringRepeatWithMap {

    public static String CheckStringDuplicate(String testString) {
        String newString = "";
        testString = testString.toLowerCase();
        String item[] = testString.split(" ");

        // Map<key, value> map;
        // tương ứng với mỗi key là value
        // <"alo", 1> thì index = 1 thì in ra "alo"
        // không có cách truy xuất từng key ra
        Map<String, Integer> map = new TreeMap<>();

        for (String t : item) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);

            } else {
                map.put(t, 1);
            }
        }


        // cái này chỉ là tách biệt key và value ra
        // phải thông qua cái này mới truy xuất được key
        // biến nó (key) thành cái chuỗi dạng mảng chỉ truy xuất được bằng foreach
        Set<String> keys = map.keySet();

        for (String key : keys) {
            if (map.get(key) > 0){
                newString += key + " : " +map.get(key) + "\n";
            }
        }
        return newString;
    }
}
