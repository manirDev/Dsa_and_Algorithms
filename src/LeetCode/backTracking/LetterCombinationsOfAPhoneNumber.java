package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        String [] phoneKeyBoard = new String[]{"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        helper(digits, res, phoneKeyBoard, 0, new StringBuilder());
        System.out.println(res);
    }
    private static void helper(String digits, List<String> res, String [] phoneKeyBoard , int idx, StringBuilder sb){
        if (sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }
        int key = Integer.parseInt(String.valueOf(digits.charAt(idx)));
        for (char c : phoneKeyBoard[key - 1].toCharArray()){
            sb.append(c);
            helper(digits, res, phoneKeyBoard, idx + 1, sb);
            sb.deleteCharAt(sb.length() -1 );
        }
    }
}
