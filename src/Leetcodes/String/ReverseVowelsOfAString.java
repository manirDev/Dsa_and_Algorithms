package Leetcodes.String;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {

        String s = "hello";
        String res = reverseVowels(s);
        System.out.println(res);

    }

    public static String reverseVowels(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        char[] a = s.toCharArray();
        while(i<j){

            if(isVowel(s.charAt(i)) && isVowel(s.charAt(j))){
                char temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            } else if (isVowel(s.charAt(i)) && !isVowel(s.charAt(j))) {
                j--;
            } else if (!isVowel(s.charAt(i)) && isVowel(s.charAt(j))) {
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

    private static boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
            return true;
        }
        else if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
            return true;
        }else {
            return false;
        }
    }
}
