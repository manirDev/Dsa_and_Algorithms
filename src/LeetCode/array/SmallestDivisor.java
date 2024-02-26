package LeetCode.array;

public class SmallestDivisor {
    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        int threshold = 6;
        int res = smallestDivisorHelper(nums, threshold);
        System.out.println(res);
    }

    private static int smallestDivisorHelper(int[] nums, int threshold) {
        int high = 0;
        int res = 0;
        for (int i=0; i<nums.length; i++){
            high = Math.max(high, nums[i]);
        }
        System.out.println(high);
        int low = 1;
        while (low <= high){
            int mid = (low + high) / 2;
            int sum  = 0;
            for (int i=0; i<nums.length; i++){
                sum = sum + (int)Math.ceil((double)nums[i]/mid);
            }
            if (sum == threshold){
                return mid;
            }
            else if (sum <= threshold) {
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }

        }
        return res;
    }
}
