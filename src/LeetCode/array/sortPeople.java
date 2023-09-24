package LeetCode.array;

import java.util.Arrays;

public class sortPeople {
    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        System.out.println(Arrays.toString(sortHelper(names, heights)));
    }
    private static String[] sortHelper(String[] names, int[] heights){
        for (int i=0; i<heights.length-1; i++){
            for (int j=i+1; j>0; j--){
                if (heights[j] > heights[j-1]){
                    heightsSwapHelper(heights, j-1, j);
                    namesSwapHelper(names, j-1, j);

                }

            }
        }
        return names;
    }

    private static void namesSwapHelper(String[] names, int first, int second) {
        String temp = names[first];
        names[first] = names[second];
        names[second] = temp;
    }
    private static void heightsSwapHelper(int[] height, int first, int second) {
        int temp = height[first];
        height[first] = height[second];
        height[second] = temp;
    }
}
