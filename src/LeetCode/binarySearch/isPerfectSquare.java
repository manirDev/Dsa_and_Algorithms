package LeetCode.binarySearch;

public class isPerfectSquare {
    public static void main(String[] args) {
        int num = 14;
        System.out.println(helper(num));
    }
    private static boolean helper(int num){
        int start = 1;
        int end = num;
        while (start <= end){
            int mid = start + (end - start)/2;
            int target = mid*mid;
            if (target == num){
                return true;
            }
            else if (target > num){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return false;
    }
}
