package LeetCode.array;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        //int[] heights = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        int[] heights = {2, 1, 5, 6, 2, 3};
        int res = largestAreaHelper(heights);
        System.out.println(res);
    }

    private static int largestAreaHelper(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int width = 0;
        stack.push(heights[0]);
        for (int height : heights){
            if (!stack.isEmpty()) {
                int countPop = 0;
                int min = Integer.MAX_VALUE;
                while (!stack.isEmpty() && stack.peek() > height) {
                    int poped = stack.pop();
                    min = Math.min(min, poped);
                    countPop++;
                }
                width = width + countPop;
                res = Math.max(res, (min * width));
                stack.push(height);
            }
        }

        return res;
    }
}
