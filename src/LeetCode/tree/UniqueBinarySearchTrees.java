package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int n = 3;
        int res = numTreesHelper(n);
        System.out.println(res);
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

}
