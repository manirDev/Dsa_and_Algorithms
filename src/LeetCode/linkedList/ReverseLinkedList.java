package LeetCode.linkedList;

import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head = head.insertNode(head, 2);
        head = head.insertNode(head, 3);
        head = head.insertNode(head, 4);
        head = head.insertNode(head, 5);
        head.print(head);
        System.out.println();
        head = reverseHelper(head);
        head.print(head);
    }
    private static ListNode reverseHelper(ListNode  head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode reversedHead = reverseHelper(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return reversedHead;
    }
}
