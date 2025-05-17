package LeetCodeCards.Array;

public class FindNumbersWithEvenNumberOfDigits {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        int res = helper(nums);
        System.out.println(res);
    }

    private static int helper(int[] nums){
        int res = 0;

        for (int num : nums){
            if (num >= -9 && num <= 9) continue;
            int digitCount = digitCountHelper(num);
            if (digitCount % 2 == 0){
                res++;
            }
        }

        return res;
    }

    private static int digitCountHelper(int num){
        int count = 0;

        num = Math.abs(num);
        while(num > 0){
            num = num/10;
            count++;
        }
        return count;
    }
}
