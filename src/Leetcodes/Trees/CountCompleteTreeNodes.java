package Leetcodes.Trees;

import java.util.ArrayList;
import java.util.List;

public class CountCompleteTreeNodes {
    int val;
    List<Integer> result = new ArrayList<>();
    CountCompleteTreeNodes left;
    CountCompleteTreeNodes right;
    CountCompleteTreeNodes() {}
    CountCompleteTreeNodes(int val) { this.val = val; }
    CountCompleteTreeNodes(int val, CountCompleteTreeNodes left, CountCompleteTreeNodes right) {
       this.val = val;
       this.left = left;
       this.right = right;
     }


    public static void main(String[] args) {

    }

    private int countNodes(CountCompleteTreeNodes root){
        return result.size();
    }

    private void inOrder(CountCompleteTreeNodes root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        result.add(root.val);
        inOrder(root.right);
    }

}
