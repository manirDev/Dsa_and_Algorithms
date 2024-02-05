package LeetCode.heap;

import java.util.*;

public class TheKWeakestRowsInAMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };
        int k = 3;
        int[] res = kWeakestRowsHelper(mat, k);
        System.out.println(Arrays.toString(res));
    }

    private static int[] kWeakestRowsHelper(int[][] mat, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> soldiers = new HashMap<>();
        for (int i=0; i<mat.length; i++){
            int count = 0;
            for (int j=0; j<mat[i].length; j++){
                if (mat[i][j] == 1){
                    count++;
                }
                else{
                    break;
                }
            }
            soldiers.put(i, count);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (s1, s2) -> {
                    if (soldiers.get(s1) != soldiers.get(s2)){
                        return (soldiers.get(s2) - soldiers.get(s1));
                    }
                    else{
                        return (s2 - s1);
                    }
                }
        );
        for (int key : soldiers.keySet()){
            minHeap.add(key);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        for (int i=k-1; i>=0; i--){
            res[i] = minHeap.remove();
        }
        return res;
    }
}
