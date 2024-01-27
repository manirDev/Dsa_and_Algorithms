package LeetCode.bitManipulation;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        int a = 1;
        int b = 3;
        int sum = getSumHelper(a, b);
        System.out.println(sum);
    }

    private static int getSumHelper(int a, int b) {
        while(b != 0){
            int sum = (a ^ b);
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }

        return a;
    }
}
