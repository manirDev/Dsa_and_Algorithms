package LeetCode.bitManipulation;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4,4};
        int res = singleNumberHelper(nums);
        System.out.println(res);
    }

    private static int singleNumberHelper(int[] nums) {
        int res = 0;
        for (int i=0; i<nums.length; i++){
            res = (res ^ nums[i]);
        }
        return res;
    }
}
