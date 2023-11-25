package LeetCode.dp;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "(()()()))";
        int res = longestValidParenthesesHelper(s);
        System.out.println(res);
    }

    private static int longestValidParenthesesHelper(String str) {
        Stack<Character> stack;
        int longestValidParenthesesLength = 0;
        for (int i=0; i<str.length(); i++){
            stack = new Stack<>();
            for (int j=i; j<str.length(); j++){
                if (stack.isEmpty() && str.charAt(j)== ')'){
                    break;
                }
                if (str.charAt(j) == '('){
                    stack.push(str.charAt(j));
                }
                else {
                    stack.pop();
                    if (stack.isEmpty()){
                        longestValidParenthesesLength = Math.max(longestValidParenthesesLength, j - i + 1);
                    }
                }
            }
        }
        return longestValidParenthesesLength;
    }
}
