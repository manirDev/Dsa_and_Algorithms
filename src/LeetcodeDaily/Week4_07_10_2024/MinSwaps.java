package LeetcodeDaily.Week4_07_10_2024;

import java.util.Stack;

public class MinSwaps {
    public static void main(String[] args) {
        String s = "][][";
        int res = helper(s);
        System.out.println(res);
    }
    private static int helper(String s){
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.add(c);
            }
            else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                else{
                    stack.add('[');
                    res = res + 1;
                }
            }
        }
        return res;
    }
}
