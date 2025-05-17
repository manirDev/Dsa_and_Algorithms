package LeetCodeCards.Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DuplicateZeros {
    public static void main(String[] args) {
        int[] nums = {1,0,0,3,0,4,5,0};
        helper(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void helper(int[] nums){
        for (int i=0; i<nums.length - 2; i++){
            if (nums[i] != 0) continue;
            else{
                int temp = nums[i + 1];
                nums[i+1] = nums[i];
                nums[i + 2] = temp;
                i = i + 2;
            }
        }
    }

}
