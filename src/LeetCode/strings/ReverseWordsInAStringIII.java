package LeetCode.strings;

public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String[] words = s.split(" ");
        String res = wordsReverseHelper(words);
        System.out.println(res);
    }

    private static String wordsReverseHelper(String[] words) {
        StringBuilder res = new StringBuilder();
        for (String word : words){
            int left  = 0;
            int right = word.length() - 1;
            char[] arr = word.toCharArray();
            while (left < right){
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            res.append(arr);
            res.append(" ");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}
