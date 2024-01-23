package LeetCode.bitManipulation;

public class ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        int num = -1;
        String res = toHexHelper(num);
        System.out.println(res);
    }

    /*2'a complement of Integer :
            of a negative num(2^32 + num)
            of a positive num(2^32 - num);
            */
    private static String toHexHelper(int num) {
        StringBuilder res = new StringBuilder();
        if (num == 0){
            return "0";
        }
        long tempNum = num;
        int base = 16;
        if (tempNum < 0){
            tempNum = (long)(Math.pow(2, 32) + num);
        }
        while (tempNum > 0){
            int mode = (int)(tempNum % base);
            String result = numberHelper(mode);
            res.append(result);
            tempNum = tempNum / base;
        }
        return res.reverse().toString();
    }

    private static String numberHelper(int mode) {
        switch (mode){
            case 10:
                return "a";
            case 11:
                return "b";
            case 12:
                return "c";
            case 13:
                return "d";
            case 14:
                return "e";
            case 15:
                return "f";
            default:
                return "" + mode;
        }
    }
}
