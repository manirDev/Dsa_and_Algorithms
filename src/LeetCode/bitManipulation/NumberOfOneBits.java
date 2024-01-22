package LeetCode.bitManipulation;

public class NumberOfOneBits {
    public static void main(String[] args) {
        int n = 4;
        int res = oneCounterHelper(n);
        System.out.println(res);
    }

    private static int oneCounterHelper(int n) {
        int res = 0;
//        while (n > 0){
//            res = res +  n % 2;
//            n = n >> 1;
//        }
        int m = 1;
        for(int i=0; i<32; i++){
            if((n & m) != 0){
                res = res + 1;
            }
            m <<= 1;
        }
        return res;
    }
}
