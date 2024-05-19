package LeetCode.hashMap;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
    public static void main(String[] args) {
        String num = "88";
        boolean res = isStrobogrammatic(num);
        System.out.println(res);
    }

    private static boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        for (char ch : num.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            }

            res.append(map.get(ch));
        }

        res.reverse();
        return num.equals(res.toString());
    }
}
