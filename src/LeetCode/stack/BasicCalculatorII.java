package LeetCode.stack;

import java.nio.charset.CharsetEncoder;
import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        String expression = "14/3*2";
        expression = expression.replaceAll(" ", "");
        int res = basicCalculatorHelper(expression);
        System.out.println(res);
    }

    private static int basicCalculatorHelper(String expression) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> operands = new Stack<>();
        for (int i=0; i<expression.length(); i++){
            char currChar = expression.charAt(i);
            if (Character.isDigit(currChar)){
                StringBuilder tempDigit = new StringBuilder();
                tempDigit.append(currChar);
                while (isNextDigit(expression, i, expression.length())){
                    tempDigit.append(expression.charAt(i+1));
                    i++;
                }
                nums.push(Integer.parseInt((tempDigit.toString())));
            }
            else {
                if (!operands.isEmpty()){
                    //char peekOperand = operands.peek();
                    while (!operands.isEmpty() && !isSameOrGreaterPrecedence(operands.peek(), currChar)){
                        int secondNum = nums.pop();
                        int firstNum = nums.pop();
                        int tempRes = arithmeticCalculation(firstNum, secondNum, operands.pop());
                        nums.push(tempRes);
                    }

                }
                operands.push(currChar);
            }
        }
        while (!operands.isEmpty()){
            int secondNum = nums.pop();
            int firstNum = nums.pop();
            int tempRes = arithmeticCalculation(firstNum, secondNum, operands.pop());
            nums.push(tempRes);
        }
        StringBuilder res = new StringBuilder();
        while (!nums.isEmpty()){
            res.append(nums.pop());
        }
        return Integer.parseInt(String.valueOf(res));
    }

    private static boolean isNextDigit(String expression, int i, int length) {
        if (i + 1 < length){
            if (Character.isDigit(expression.charAt(i+1))){
                return true;
            }
        }
        return false;
    }

    private static int arithmeticCalculation(int firstNum, int secondNum, Character operand) {
        switch (operand){
            case '+':
                return firstNum + secondNum;
            case '-':
                return firstNum - secondNum;
            case '*':
                return firstNum * secondNum;
            case '/':
                return firstNum / secondNum;
            default:
                return 0;
        }
    }

    private static boolean isSameOrGreaterPrecedence(char peekOperand, char currChar) {

        if ((peekOperand == '+' && currChar == '*') || (peekOperand == '-' && currChar == '*')) {
            return true;
        }
        else if ((peekOperand == '+' && currChar == '/') || (peekOperand == '-' && currChar == '/')) {
            return true;
        }
        else{
            return false;
        }
    }
}
