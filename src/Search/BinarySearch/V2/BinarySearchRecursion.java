package Search.BinarySearch.V2;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 7, 8, 9, 11};
        int target = 25;
        System.out.println("Recursive Function:");
        long time = System.currentTimeMillis();
        System.out.println(helper(nums, target, 0, nums.length-1));
        System.out.printf("Time using Recursion: %d ms\n", System.currentTimeMillis() - time);
    }
    private static int helper(int[] a, int t, int s, int e){
        if (s > e){
            return -1;
        }
        int mid = s + (e - s)/2;
        if (a[mid] == t){
            return mid;
        }
        else if (a[mid] < t){
            return helper(a, t, mid + 1, e);
        }
        else{
            return helper(a, t, s, mid - 1);
        }
    }
}
