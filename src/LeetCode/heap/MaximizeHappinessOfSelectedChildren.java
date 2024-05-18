package LeetCode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximizeHappinessOfSelectedChildren {
    public static void main(String[] args) {
        int[] happiness = {2,3,4,5};
        int k = 2;
        int res =  findMaxHappinessSumHelper(happiness, k);
        System.out.println(res);
    }

    private static int findMaxHappinessSumHelper(int[] happiness, int k) {
        int res = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int happ : happiness){
            maxHeap.add(happ);
        }
        int i = 0;
        while (k > 0){
            res = res + Math.max(maxHeap.poll() - i, 0);
            i++;
            k--;
        }

        return res;
    }
}
