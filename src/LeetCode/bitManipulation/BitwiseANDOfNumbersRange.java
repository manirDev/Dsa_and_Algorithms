package LeetCode.bitManipulation;

public class BitwiseANDOfNumbersRange {
    public static void main(String[] args) {
        int left = 5;
        int right = 7;
        int res = rangeANDHelper(left,  right);
        int res2 = rangeANDHelper2(left,  right);
        int res3 = rangeORHelper(left,  right);
        System.out.println(res);
        System.out.println(res3);
    }

    private static int rangeORHelper(int left, int right) {
        if (left == 0 && right != 0){
            return right;
        }
        if (left != 0 && right == 0){
            return left;
        }
        if(left == right){
            return right;
        }
        int count = 0;
        while (left != right){
            right = right << 1;
            left = left << 1;
            count++;
        }
        return (right >> count);
    }

    private static int rangeANDHelper2(int left, int right) {
        if (left == 0 || right == 0){
            return 0;
        }
        if(left == right){
            return right;
        }
        int count = 0;
        while (left != right){
            right = right >> 1;
            left = left >> 1;
            count++;
        }
        return (right << count);
    }

    private static int rangeANDHelper(int left, int right) {
        if (left == 0 || right == 0){
            return 0;
        }
        int res = left;
        while (left <= right){
            res = res & left++;
        }
        return res;
    }
}
