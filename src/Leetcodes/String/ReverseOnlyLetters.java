package Leetcodes.String;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String s = "ab-cx?d";
        String res = reverseOnlyLetters(s);
        System.out.println(res);
    }
    public static String reverseOnlyLetters(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] a = s.toCharArray();
        while(i<j){

            if(isLetter(s.charAt(i)) && isLetter(s.charAt(j))){
                char temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            } else if (isLetter(s.charAt(i)) && !isLetter(s.charAt(j))) {
                j--;
            } else if (!isLetter(s.charAt(i)) && isLetter(s.charAt(j))) {
                i++;
            }else{
                i++;
                j--;
            }
        }
        StringBuilder res = new StringBuilder();
        res.append(a);
        return res.toString();
    }

    private static boolean isLetter(char c){
        if(c >= 'a' && c<='z'){
            return true;
        }
        else if(c >= 'A' && c <= 'Z'){
            return true;
        }else {
            return false;
        }
    }
}
