package Leetcodes.String;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SwapAdjacentInLRStringV3 {
    public static void main(String[] args) {
        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";
        boolean flag = helper(start, end);
        if (flag){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }

    private static  boolean helper(String s, String e){
        if (s.length()!=e.length()){
            return false;
        }
        int sCountX = 0, eCountX = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == 'X') sCountX++;
            if (e.charAt(i) == 'X') eCountX++;
        }
        if (sCountX != eCountX) return false;
        //Create Lists to store R and L indexes respectively
        List<Integer> indexRS = new ArrayList<>();
        List<Integer> indexLS = new ArrayList<>();
        List<Integer> indexRE = new ArrayList<>();
        List<Integer> indexLE = new ArrayList<>();

        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='R') indexRS.add(i);
            if (s.charAt(i)=='L') indexLS.add(i);
        }
        for (int i=0; i<e.length(); i++){
            if (e.charAt(i)=='R') indexRE.add(i);
            if (e.charAt(i)=='L') indexLE.add(i);
        }
        int i=0, j=0;
        while (i<indexRS.size() && j<indexRE.size()){
            if (indexRS.get(i) > indexRE.get(j)){
                return false;
            }
            i++;
            j++;
        }
        i = 0;
        j = 0;
        while (i<indexLS.size() && j<indexLE.size()){
            if (indexLS.get(i) <= indexLE.get(j)){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
