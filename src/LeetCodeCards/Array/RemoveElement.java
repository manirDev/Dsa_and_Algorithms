package LeetCodeCards.Array;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3};
        int val = 2;
        int res = helper(nums, val);
        System.out.println(Arrays.toString(nums) + " res: " + res);
    }

    private static int helper(int[] nums, int val){
        int count = 0;

        for (int i=0; i<nums.length; i++){
            if (nums[i] != val){
                nums[count++] = nums[i];
            }
        }

        return  count;
    }
}
