package Leetcodes.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);
        for (int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }
    private static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, 0, temp, result);
        return result;
    }
    private static void helper(int[] a, int i, List<Integer> temp, List<List<Integer>> list){
        if (i==a.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        helper(a, i+1, temp, list);
        temp.add(a[i]);
        helper(a, i+1, temp, list);
        temp.remove(temp.size()-1);
    }
}
