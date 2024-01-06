package LeetCode.linkedList;

import java.util.List;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head = head.insertNode(head, 3);
        head = head.insertNode(head, 2);
        head = head.insertNode(head, 1);
        head.print(head);
        System.out.println();
        ListNode res = swapHelper(head);
        res.print(res);
    }
    private static ListNode swapHelper(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        left.next = swapHelper(head.next.next);
        right.next = left;
       return right;
    }
}
