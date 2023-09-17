package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {

    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode middle = helper(head);
        TreeNode root = new TreeNode(middle.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middle.next);
        return root;
    }
    private ListNode helper(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev != null) prev.next = null;
        return slow;
    }
}
