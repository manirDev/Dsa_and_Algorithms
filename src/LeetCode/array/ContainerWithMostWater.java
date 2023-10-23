package LeetCode.array;

import org.w3c.dom.ls.LSOutput;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int res = areaHelper(height);
        System.out.println(res);
    }

    private static int areaHelper(int[] height) {
        int res = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left < right){
            int width = right - left;
            int area = width * Math.min(height[left], height[right]);
            res = Math.max(res, area);
            if (height[left] < height[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return res;
    }
}
