package LeetcodeDaily.Week4_07_10_2024;

import java.util.Stack;

public class MinAddToMakeValid {
    public static void main(String[] args) {
        String s = "())";
        int res = helper(s);
        System.out.println(res);
    }
    private static int helper(String s){
        Stack<Character> stack = new Stack<>();
        int closeCount = 0;
        for (char c : s.toCharArray()){
            if (c == '('){
                stack.push(c);
            }
            else{
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
                else{
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty() ? 0 : stack.size();
    }
}
