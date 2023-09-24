package LeetCode.array;

import java.util.ArrayList;
import java.util.List;

public class sortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        sortHelper(nums, odd, even, 0);
        List<Integer> res = new ArrayList<>();
        res.addAll(even);
        res.addAll(odd);
        System.out.println(res);
    }
    private static void sortHelper(int[] nums, List<Integer> odd, List<Integer> even, int i){
        if (i >= nums.length){
            return;
        }
        if (nums[i] % 2 == 0){
            even.add(nums[i]);
            sortHelper(nums, odd, even, i+1);
        }
        else {
            odd.add(nums[i]);
            sortHelper(nums, odd, even, i+1);
        }
    }
}
