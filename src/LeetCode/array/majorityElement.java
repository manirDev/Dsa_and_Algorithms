package LeetCode.array;

public class majorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(helper(nums));
    }

    private static int helper(int[] nums) {
        int count = 0;
        int target = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            if (count == 0){
                target = nums[i];
            }
            if (nums[i] == target){
                target = nums[i];
                count++;
            }
            else {
                count--;
            }
        }
        return target;
    }
}
