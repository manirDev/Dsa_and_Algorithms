package LeetCode.bitManipulation;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        int n = 5;
        int[] res = countBitsHelper(n);
        System.out.println(Arrays.toString(res));
    }

    private static int[] countBitsHelper(int n) {
        int[] res = new int[n + 1];
        for (int i=0; i<=n; i++){
            int mask = 1;
            int count = bitHelper(i, mask);
            res[i] = count;
        }
        return  res;
    }

    private static int bitHelper(int val, int mask) {
        int count = 0;
        for (int i=0; i<32; i++){
            if ((val & mask) != 0){
                count = count + 1;
            }
            mask <<= 1;
        }
        return count;
    }
}
