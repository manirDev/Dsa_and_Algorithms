package LeetcodeDaily.Week1_16_09_2024;

public class ShortestPalindrome {
    public static void main(String[] args) {
        String s = "abcd";
        String res = helper(s);
        System.out.println(res);
    }
    private static String helper(String s){
        int idx = s.length() - 1;
        while (idx >= 0){
            String subStr = s.substring(0, idx + 1);
            if (isPalindrome(subStr)){
                break;
            }
            idx--;
        }
        String suffix = s.substring(idx + 1);
        StringBuilder res = new StringBuilder(suffix);
        return res.reverse().toString() + s;
    }
    private static boolean isPalindrome(String s){
        int start = 0;
        int end =  s.length() - 1;
        while (start < end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
