package LeetCode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int n = 3;
        int res = numTreesHelper(n);
        System.out.println(res);
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(numTreeHelperV2(memo, n));
    }

    private static int numTreesHelper(int n) {
        if (n == 0 || n == 1){
            return 1;
        }
        int totalTree = 0;
        for (int i=1; i<=n; i++){
            totalTree += numTreesHelper(i - 1) * numTreesHelper(n-i);
        }
        return totalTree;
    }
    private static int numTreeHelperV2(int[] memo, int n){
        if (n == 0 || n == 1){
            return 1;
        }
        if (memo[n] != -1){
            return memo[n];
        }
        int totalTree = 0;
        for (int i=1; i<=n; i++){
            totalTree += numTreeHelperV2(memo, i - 1) * numTreeHelperV2(memo, n - i);
        }
        memo[n] = totalTree;
        return memo[n];
    }

}
