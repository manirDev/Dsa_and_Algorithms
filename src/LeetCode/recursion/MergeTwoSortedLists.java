package LeetCode.recursion;

import LeetCode.linkedList.ListNode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        head1 = head1.insertNode(head1, 2);
        head1 = head1.insertNode(head1, 1);
        ListNode head2 = new ListNode(4);
        head2 = head2.insertNode(head2, 3);
        head2 = head2.insertNode(head2, 1);
        ListNode res = mergeHelper(head1, head2);
        res.print(res);
    }
    private static ListNode mergeHelper(ListNode head1, ListNode head2){
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }
        if (head1.val < head2.val){
            head1.next = mergeHelper(head1.next, head2);
            return head1;
        }
        else{
            head2.next =  mergeHelper(head1, head2.next);
            return head2;
        }
    }
}
