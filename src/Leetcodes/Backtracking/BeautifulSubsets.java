package Leetcodes.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class BeautifulSubsets {
    public static void main(String[] args) {
        int[] nums = {2,4,6};
        int k = 2;
        int count = 0;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, k, 0, temp, list);
        System.out.println(list.size());
    }

    private static void helper(int[] a, int k, int i, List<Integer> temp, List<List<Integer>> list){
        if (i==a.length){
            if (temp.size()>0){
                list.add(new ArrayList<>(temp));
            }
            return;
        }
        if (!temp.contains(Math.abs(a[i]-k))){
            temp.add(a[i]);
            helper(a, k, i+1, temp, list);
            temp.remove(temp.size()-1);
        }
        helper(a, k, i+1, temp, list);
    }
}
