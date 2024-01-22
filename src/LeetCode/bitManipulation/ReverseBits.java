package LeetCode.bitManipulation;

public class ReverseBits {
    public static void main(String[] args) {
        int n = 4;
        int res = reverseBitsHelper(n);
        System.out.println(res);
    }

    private static int reverseBitsHelper(int n) {
        int res = 0;
        int mask = 1;
        int shift = 31;

        for (int i = 0; i<32; i++){
            int bit = n & mask;
            res = res | (bit <<= shift);
            mask <<= 1;
            shift--;
        }
        return res;
    }
}
