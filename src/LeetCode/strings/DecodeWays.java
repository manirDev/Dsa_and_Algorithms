package LeetCode.strings;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "226";
        int res = numDecodingHelper(s);
        System.out.println(res);
    }

    private static int numDecodingHelper(String s) {
        if (s.isEmpty() || s.charAt(0) == '0'){
            return 0;
        }
        int[] table = new int[s.length() + 1];
        table[0] = 1;
        table[1] = 1;
        for (int i=2; i<=s.length(); i++){
            int oneDigit = Integer.parseInt(s.substring(i-1, i));
            int twoDigits = Integer.parseInt(s.substring(i-2, i));
            if (oneDigit >= 1){
                table[i] = table[i] + table[i-1];
            }
            if (twoDigits >= 10 && twoDigits <= 26){
                table[i] = table[i] + table[i-2];
            }
        }
        return table[table.length - 1];
    }
}
