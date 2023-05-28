package Leetcodes.Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class Combinations {
    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> res = combine(n, k);
        for (int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }
    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = i+1;
        }
        helper(n, k, 0, arr, temp, result);
        return result;
    }
    private static void helper(int n, int k, int i, int[] a, List<Integer> temp, List<List<Integer>> list){
        if (i == a.length){
            if (temp.size() == k){
                list.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(a[i]);
        helper(n, k, i+1, a, temp, list);
        temp.remove(temp.size()-1);
        helper(n, k, i+1, a, temp, list);
    }
}
