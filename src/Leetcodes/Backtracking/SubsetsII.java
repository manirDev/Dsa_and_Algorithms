package Leetcodes.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> res = subsetsWithDup(nums);
        for (int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }
    private static List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, temp, result);
        return result;
    }
    private static void helper(int[] a, int index, List<Integer> temp, List<List<Integer>> list){
        list.add(new ArrayList<>(temp));
        for (int i=index; i<a.length; i++){
            if (i != index && a[i] == a[i-1]){
                continue;
            }
            temp.add(a[i]);
            helper(a, i+1, temp, list);
            temp.remove(temp.size()-1);
        }
    }
}
