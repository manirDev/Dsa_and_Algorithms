package LeetCode.binarySearch;

public class guessNumber {
    public static void main(String[] args) {

    }

    private static int helper(int n){
        int start = 0;
        int end = n;
        while (start <= end){
            int mid = start + (end - start)/2;
            int guessed = guess(mid);
            if (guessed == 0){
                return mid;
            }
            else if (guessed == -1){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int guess(int mid) {
        return mid;
    }
}
