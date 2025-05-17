package LeetCodeCards.Array;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,1,1};
        int res = helper(arr);
        System.out.println(res);
    }
    private static int helper(int[] arr){
        int res = 0;
        int counter = 0;
        for (int num : arr){
            if (num == 1){
                counter++;
            }
            else{
                counter = 0;
            }
            res = Math.max(res, counter);
        }

        return res;
    }
}
