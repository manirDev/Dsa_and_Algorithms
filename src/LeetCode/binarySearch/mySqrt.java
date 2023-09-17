package LeetCode.binarySearch;

public class mySqrt {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(helper(x));
    }
    private static int helper(int x){
        int start = 1;
        int end = x;
        if (x == 1) return x;
        while (start <= end){
            int mid = start + (end - start)/2;
            long target = (long)mid*mid;
            if (target == x){
                return mid;
            }
            else if (target > x){
                end = mid -1;
            }
            else{
                start = mid + 1;
            }
        }
        return end;
    }
}
