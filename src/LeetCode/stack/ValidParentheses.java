package LeetCode.stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "[({)]";
        boolean res = validParenthesesHelper(s);
        System.out.println(res);
    }

    private static boolean validParenthesesHelper(String s) {
        Stack<Character> res = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                res.push(c);
            }
            else{
                char peekChar = res.peek();
                if (!isOpenAndClose(peekChar, c)){
                    return false;
                }
                res.pop();
            }
        }
        return res.isEmpty();
    }

    private static boolean isOpenAndClose(char open, char close) {
        return ((open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}'));
    }
}
