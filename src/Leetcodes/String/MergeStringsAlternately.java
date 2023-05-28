package Leetcodes.String;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        String res = mergeAlternately(word1, word2);
        System.out.println(res);
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int i = 0, j = 0;
        while(i<word1.length() && j<word2.length()){
            merged.append(word1.charAt(i));
            merged.append(word2.charAt(j));
            i++;
            j++;
        }
        while (i<word1.length()){
            merged.append(word1.charAt(i));
            i++;
        }
        while (j<word2.length()){
            merged.append(word2.charAt(j));
            j++;
        }
        return merged.toString();
    }
}
