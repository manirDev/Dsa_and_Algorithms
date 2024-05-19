package LeetCode.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberII {
    public static void main(String[] args) {
        int n = 1;
        List<String> res = findStrobogrammaticHelper(n);
        System.out.println(res.toString());
    }
    private static List<String> findStrobogrammaticHelper(int n) {
        Map<Character, Character> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int startValue = (int) Math.pow(10, n - 1);
        for (int i = startValue; i < Math.pow(10, n); i++) {
            StringBuilder sb = new StringBuilder();
            String formattedNum = String.format("%0" + n + "d", i);
            for (char ch : formattedNum.toCharArray()) {
                if (!map.containsKey(ch)) {
                    break;
                }
                sb.append(map.get(ch));
            }
            sb.reverse();
            if(formattedNum.equals(sb.toString()) ){
                res.add(formattedNum);
            }
        }
        return res;
    }
}
