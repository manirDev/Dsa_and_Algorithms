package Leetcodes.String;

/**
 Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 A subsequence of a string is a new string generated from the original string with some characters (can be none)
 deleted without changing the relative order of the remaining characters.
 For example, "ace" is a subsequence of "abcde".

 Example 1:
 Input: s = "abcde", words = ["a","bb","acd","ace"]
 Output: 3
 Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 Example 2:

 Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 Output: 2
 **/
public class NumberOfMatchingSubsequences {
    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a","bb","acd","ace"};
        System.out.println(numMatchingSubseq(s, words));
    }

    public static int numMatchingSubseq(String s, String[] words){
        int count = 0;
        for (String w : words) {
            int i = 0, j = 0;
            StringBuilder sb = new StringBuilder();
            while (i<w.length() && j<s.length()){
                if(w.charAt(i) == s.charAt(j)){
                    sb.append(w.charAt(i));
                    i++;
                }
                j++;
            }
            if(w.equals(sb.toString())){
                count++;
            }
        }
        return count;
    }
}
