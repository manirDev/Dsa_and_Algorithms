package LeetcodeDaily.Week1_16_09_2024;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        String res = helper(nums);
        System.out.println(res);
    }
    private static String helper(int[] nums){
        StringBuilder res = new StringBuilder();
        int len = nums.length;
        String[] s = new String[len];
        for (int i=0; i<len; i++){
            s[i] = String.valueOf(nums[i]);
        }
        for (int i=0; i<len; i++){
            int lastIdx = len - i - 1;
            int maxIdx = getMax(s, 0, lastIdx);
            swap(s, maxIdx, lastIdx);
        }
        if(s[len - 1].equals("0")){
            return "0";
        }
        for (int i=len-1; i>=0; i--){
            res.append(s[i]);
        }
        return res.toString();
    }
    private static int getMax(String[] s, int start, int end){
        String max = s[start];
        int maxIdx = start;
        for (int i = start + 1; i <= end; i++) {
            int compare = (max + s[i]).compareTo(s[i] + max);
            if (compare < 0) {
                max = s[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    private static void swap(String[] s, int maxIdx, int lastIdx){
        String temp = s[maxIdx];
        s[maxIdx] = s[lastIdx];
        s[lastIdx] = temp;
    }

}
