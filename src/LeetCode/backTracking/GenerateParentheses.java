package LeetCode.backTracking;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 1;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder("(");
        generateHelper(res, sb, true, true, n - 1, n, 2*n);
        System.out.println(res);
    }

    private static void generateHelper(List<String> res, StringBuilder sb, boolean isOpen, boolean isClose, int openSize, int closeSize, int len) {
        if(sb.length() == len){
            res.add(sb.toString());
            return;
        }
        if (openSize == 0){
            isOpen = false;
        }
        if (closeSize == 0){
            isClose = false;
        }
        if (isOpen && closeSize > 0){
            sb.append("(");
            generateHelper(res, sb, isOpen, isClose, openSize - 1, closeSize, len);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (isClose && openSize < closeSize){
            sb.append(")");
            generateHelper(res, sb, isOpen, isClose, openSize, closeSize - 1, len);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
