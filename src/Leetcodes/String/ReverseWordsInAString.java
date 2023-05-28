package Leetcodes.String;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "  hello world  ";
        String res = reverseWords(s);
        System.out.println(res);
    }

    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] arr = s.split(" ");
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            if (!isSpace(arr[left]) && !isSpace(arr[right])){
                String temp  = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            if (!isSpace(arr[left]) && isSpace(arr[right])){
                right--;
            }
            if (isSpace(arr[left]) && !isSpace(arr[right])){
                left++;
            }else {
                left++;
                right--;
            }
        }

        for (int i=0; i<arr.length; i++){
            if(i!=arr.length){
                res.append(arr[i]);
                res.append(" ");
            }
        }
        return res.toString();
    }
    private static boolean isSpace(String s){
        if (s == " "){
            return true;
        }
        return false;
    }
}
