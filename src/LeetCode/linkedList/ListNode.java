package LeetCode.linkedList;

import java.util.List;

public class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int val){
        this.val = val;
    }

    public ListNode insertNode(ListNode head, int val){
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        return head;
    }
    public void print(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.printf(temp.val + " ");
            temp = temp.next;
        }
    }
}
