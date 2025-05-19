package LeetCodeCards.Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DuplicateZeros {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 3, 0, 4, 5, 0};
        helper(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void helper(int[] nums){
        int len = nums.length;
        int count = 0;

        for (int i=0; i + count < len; i++){
            if (nums[i] == 0){
                if (i + count == len - 1){
                    nums[len - 1] = 0;
                    len--;
                    break;
                }
                count++;
            }
        }
        int lastPoint = len - count - 1;
        for (int i=lastPoint; i>=0; i--){
            if (nums[i] == 0){
                nums[i + count] = 0;
                count--;
                nums[i + count] = 0;
            }
            else{
                nums[i + count] = nums[i];
            }
        }
    }

}
