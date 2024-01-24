package LeetCode.bitManipulation;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        int a = 1;
        int b = 3;
        int sum = getSumHelper(a, b);
        System.out.println(sum);
    }

    private static int getSumHelper(int a, int b) {
        int res = 0;
        if (a == 0) return b;
        if (b == 0) return a;
        int mask = 1;
        for (int i=31; i>=0; i--){
            int xorRes = a^b;
            if ((a & mask) == 1 && (b & mask) == 1){

            }
            mask <<= 1;

        }

        return 0;
    }
}
