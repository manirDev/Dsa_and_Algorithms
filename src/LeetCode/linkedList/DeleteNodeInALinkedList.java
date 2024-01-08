package LeetCode.linkedList;

public class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head = head.insertNode(head, 1);
        head = head.insertNode(head, 5);
        head = head.insertNode(head, 4);
        head.print(head);
        ListNode node = new ListNode(5);
        deleteNodeHelper(head);
        System.out.println();
        head.print(head);
    }

    private static void deleteNodeHelper(ListNode head) {
        if (head.next.next == null){
            head.val = head.next.val;
            head.next = null;
            return;
        }
        head.val = head.next.val;
        deleteNodeHelper(head.next);
    }
}
