package LeetCode.bitManipulation;

import java.util.Enumeration;
import java.util.Map;

public class Base7 {
    public static void main(String[] args) {
        int n = -7;
        String res = toBaseSevenHelper(n);
        System.out.println(res);
    }

    private static String toBaseSevenHelper(int n) {
        StringBuilder res = new StringBuilder();
        if (n == 0){
            return "";
        }
        int tempNum = Math.abs(n);
        int base = 7;
        while (tempNum > 0){
            int mode = tempNum % base;
            res.append(mode);
            tempNum = tempNum / base;
        }
        res.reverse();
        return n < 0 ? ("-" + res.toString()) : res.toString();
    }
}
