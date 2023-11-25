package LeetCode.strings;

public class ZigzagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        StringBuilder res = new StringBuilder();
        int numRows = 3;
        convertHelper(s, numRows, 0, 0, new StringBuilder(), res,'D');
        System.out.println(res.toString());
    }

    private static void convertHelper(String s, int numRows, int idx, int row, StringBuilder sb, StringBuilder res, char dir) {
        return;
    }
}

