package LeetcodeDaily.Week3_30_09_2024;

import java.util.Arrays;

public class DividePlayers {
    public static void main(String[] args) {
        int[] skill = {3,2,5,1,3,4};
        int res = helper(skill);
        System.out.println(res);
    }
    private static int helper(int[] skill){
        if (skill.length % 2 != 0){
            return -1;
        }
        if (skill.length == 2){
            return (skill[0] * skill[1]);
        }
        Arrays.sort(skill);
        int start = 0, end = skill.length - 1;
        int currSum = skill[start] + skill[end];
        int res = skill[start] * skill[end];
        start += 1;
        end -= 1;
        while (start < end){
            int pairSum = skill[start] + skill[end];
            if (pairSum != currSum){
                return  -1;
            }
            res = res + (skill[start] * skill[end]);
            start++;
            end--;
        }
        return res;
    }
}
