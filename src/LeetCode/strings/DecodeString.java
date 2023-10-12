package LeetCode.strings;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String msj = "100[a]";
        String res = decodeStringHelper(msj);
        System.out.println(res);
    }

    private static String decodeStringHelper(String msj) {
        Stack<Integer> numsStack = new Stack<>();
        Stack<String> stringsStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        res.append("");
        for (int i=0; i<msj.length(); i++){
            char currChar = msj.charAt(i);
            if (Character.isDigit(currChar)){
                char nextChar = msj.charAt(i+1);
                char nextNextChar = msj.charAt(i+2);
                int num = 0;
                if (Character.isDigit(nextChar) && Character.isDigit(nextNextChar)){
                    num = Integer.parseInt(msj.substring(i, i+3));
                    numsStack.push(num);
                    i += 2;
                }
                else if (Character.isDigit(nextChar)){
                    num = Integer.parseInt(msj.substring(i, i+2));
                    numsStack.push(num);
                    i += 1;
                }
                else {
                    num = Integer.parseInt(String.valueOf(currChar));
                    numsStack.push(num);
                }
            }
            if (currChar == '['){
                stringsStack.push(res.toString());
                res = new StringBuilder();
                res.append("");
            }
            if (currChar == ']'){
                int popNum = numsStack.pop();
                String popStr = stringsStack.pop();
                String tempStr = res.toString();
                res.delete(0, res.length());
                tempStr = tempStr.repeat(popNum);
                res.append(tempStr);
                res.insert(0, popStr);
            }
            if (Character.isAlphabetic(currChar)){
                res.append(currChar);
            }
        }
        return res.toString();
    }
}
