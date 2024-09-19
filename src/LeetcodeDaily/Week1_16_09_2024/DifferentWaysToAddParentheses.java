package LeetcodeDaily.Week1_16_09_2024;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        String expression = "2*3-4*5";
        List<Integer> res = helper(expression);
        System.out.println(res);
    }
    private static List<Integer> helper(String expression){
        int len = expression.length();
        List<Integer> res = new ArrayList<>();
        if (len == 0){
            return res;
        }
        if (len == 1){
            res.add(Integer.parseInt(expression));
            return res;
        }
        if (len == 2 && Character.isDigit(expression.charAt(0))){
            res.add(Integer.parseInt(expression));
            return res;
        }
        for (int i=0; i<len; i++){
            char c = expression.charAt(i);
            if (Character.isDigit(c)){
                continue;
            }
            List<Integer> leftTree = helper(expression.substring(0, i));
            List<Integer> rightTree = helper(expression.substring(i + 1));
            for (int left : leftTree){
                for (int right : rightTree){
                    if (c == '+'){
                        res.add(left + right);
                    }
                    else if (c == '-'){
                        res.add(left - right);
                    }
                    else{
                        res.add(left * right);
                    }
                }
            }
        }
        return res;
    }
}
