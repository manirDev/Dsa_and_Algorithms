package LeetcodeDaily.Week1_16_09_2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestInLexicographicalOrder {
    public static void main(String[] args) {
        int n = 13, k = 2;
        int res = lexicoKtHelper(n, k);
        System.out.println(res);
    }

    private static int lexicoKtHelper(int n, int k){
        int curr = 1;
        k--;

        while (k > 0) {
            int count = countNumbersInRange(curr, n);
            if (count <= k) {
                curr++;
                k -= count;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    private static int countNumbersInRange(int curr, int n) {
        int count = 0;
        long next = curr + 1;
        long currentLevel = curr;

        while (currentLevel <= n) {
            count += (int) (Math.min(n + 1, next) - currentLevel);
            currentLevel *= 10;
            next *= 10;
        }

        return count;
    }
    private static int helper(int n, int k){
        //PriorityQueue<String> heap = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> res = new ArrayList<>();
        int curr = 1;
        for (int i=0; i<n; i++){
            res.add(curr);
            if (res.size() > k){
                res.remove(res.size() - 1);
            }
            if (curr * 10 <= n){
                curr = curr * 10;
            }
            else if ((curr % 10) != 9 && (curr + 1) <= n) {
                curr = curr + 1;
            }
            else {
                while ((curr / 10) % 10 == 9){
                    curr = curr / 10;
                }
                curr = curr / 10 + 1;
            }
        }

        return  res.get(res.size() - 1);
    }
}
