package LeetCode.prefixSum;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        int res = pivotIndexHelper(nums);
        System.out.println(res);
    }

    private static int pivotIndexHelper(int[] nums) {
        int n = nums.length;
        int[] pSums = new int[n];
        pSums[0] = nums[0];
        for (int i=1; i<n; i++){
            pSums[i] = pSums[i-1] + nums[i];
        }
         for (int i=0; i<n; i++){
             if (i == 0){
                 if (pSums[i] == pSums[n-1]){
                     return i;
                 }
             }
             else{
                 int lefSum = pSums[i-1];
                 int rightSum = pSums[n-1];
                 if (lefSum == (rightSum - pSums[i])){
                     return i;
                 }
             }
         }
        return -1;
    }

}
