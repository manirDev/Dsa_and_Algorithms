package LeetCode.prefixSum;

public class RangeSum1D {
    int[] pSums;
    public RangeSum1D(int[] nums) {
        pSums = new int[nums.length];
        pSums[0] = nums[0];
        for (int i=1; i<nums.length; i++){
            pSums[i] = pSums[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return left > 0 ? pSums[right] - pSums[left - 1] : pSums[right];
    }
    public static void main(String[] args) {
        RangeSum1D rangeSum1D = new RangeSum1D(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(rangeSum1D.sumRange(0, 2));
        System.out.println(rangeSum1D.sumRange(2, 5));
        System.out.println(rangeSum1D.sumRange(0, 5));
    }
}
