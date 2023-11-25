package LeetCode.binarySearch;

public class FirstBadVersion {
    public static void main(String[] args) {
        int n = 5;
        int res = firstBadVersionHelper(1, n);
        System.out.println(res);
    }

    private static int firstBadVersionHelper(int start, int end) {
        while (start < end){
            int mid = start + (end - start)/2;
            if (isBadVersion(mid)){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean isBadVersion(int mid) {
        return true;
    }
}
