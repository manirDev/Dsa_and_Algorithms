package LeetCode.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "LVIII";
        int res = convertHelper(s);
        System.out.println(res);
    }

    private static int convertHelper(String s){
        Map<Character, Integer> romans = new HashMap<>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
        romans.put('O', 0);
        s = s + 'O';
        int res = 0;
        for (int i=0; i<s.length() - 1; i++){
            if (romans.get(s.charAt(i)) < romans.get(s.charAt(i + 1))){
                res = res - romans.get(s.charAt(i));
            }
            else{
                res = res + romans.get(s.charAt(i));
            }
        }

        return res;
    }
}
