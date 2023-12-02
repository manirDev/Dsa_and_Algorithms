package LeetCode.array;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,0,1,1,1};
        int res =consecutiveOnesHelper(nums);
        System.out.println(res);
    }

    private static int consecutiveOnesHelper(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int i : nums){
            if (i == 1){
                count++;
                if (count > maxCount){
                    maxCount = count;
                }
            }
            if (i == 0){
                count = 0;
            }
        }
        return maxCount;
    }
}
