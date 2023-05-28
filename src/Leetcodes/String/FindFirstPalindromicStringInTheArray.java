package Leetcodes.String;

public class FindFirstPalindromicStringInTheArray {
    public static void main(String[] args) {
        String[] words = {"abc","car","ada","racecar","cool"};
        String res = firstPalindrome((words));
        System.out.println(res);
    }
    public static String firstPalindrome(String[] words) {
        for (String s: words) {
            if (isPalindrome(s)){
                return s;
            }
        }
        return "";
    }

    private static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() -1;

        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
