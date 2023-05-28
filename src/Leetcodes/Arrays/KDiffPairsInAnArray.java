package Leetcodes.Arrays;

public class KDiffPairsInAnArray {
    public static void main(String[] args) {
        int[] nums = {3,1,4,1,5};
        int  k = 2;
        System.out.println(findPairs(nums, k));
    }

    /**
     A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

     0 <= i, j < nums.length
     i != j
     nums[i] - nums[j] == k
     Notice that |val| denotes the absolute value of val.
     **/
    private static int findPairs(int[] nums, int k){
        int count = 0;
        for (int i=0; i<nums.length-1; i++){
            for (int j=i+1; j<nums.length; j++){
                if (Math.abs(nums[i] - nums[j])==k){
                    count++;
                }
            }
        }
        return count;
    }
}
