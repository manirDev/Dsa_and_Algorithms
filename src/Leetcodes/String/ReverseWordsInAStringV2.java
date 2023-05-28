package Leetcodes.String;

public class ReverseWordsInAStringV2 {
    public static void main(String[] args) {
        String s = "  hello world  ";
        String res = reverseWords(s);
        System.out.println(res);
    }

    public static String reverseWords(String s){
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        int i = arr.length - 1;
        while(i>=0){
            if (!isSpace(arr[i])){
                if (sb.length() != 0){
                    sb.append(" ");
                }
                sb.append(arr[i]);
            }
            i--;
        }

        return sb.toString();
    }
    private static boolean isSpace(String s){
        if (s == ""){
            return true;
        }
        return false;
    }
}
