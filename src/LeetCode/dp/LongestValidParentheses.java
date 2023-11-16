package LeetCode.dp;

import java.util.Stack;

public class LongestValidParentheses {
    static  int count = 0;
    public static void main(String[] args) {
        String s = ")()())";
        int res = longestValidParenthesesHelper(s.toCharArray(), 0, new Stack<>());
        System.out.println(res);
    }

    private static int longestValidParenthesesHelper(char[] str, int idx, Stack<Character> stack) {
        if (idx >= str.length){
            return 0;
        }
        if (!stack.isEmpty() && stack.peek() == '(' && str[idx] == ')'){
            stack.pop();
            return 1;
        }
        int pick = 0;
        int nonPick = 0;
        if (str[idx] == '('){
            stack.push(str[idx]);
            pick = longestValidParenthesesHelper(str, idx + 1, stack);
        }
        else nonPick = longestValidParenthesesHelper(str, idx + 1, stack);
        return Math.max(pick, nonPick);
    }
}
