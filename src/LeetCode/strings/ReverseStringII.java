package LeetCode.strings;

public class ReverseStringII {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String res = reverseStrHelper(s, k);
        System.out.println(res);
    }

    private static String reverseStrHelper(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i=0; i<s.length(); i += 2*k){
            int left = i;
            int right = Math.min(i + k - 1, s.length());
            while (left < right){
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}
