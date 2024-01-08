package LeetCode.linkedList;

public class RemoveNodesFromLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(8);
        head = head.insertNode(head, 3);
        head = head.insertNode(head, 13);
        head = head.insertNode(head, 2);
        head = head.insertNode(head, 5);
        head.print(head);
        System.out.println();
        head = removeHelper(head);
        head.print(head);
    }

    private static ListNode removeHelper(ListNode head) {
        if (head == null){
            return null;
        }
        head.next = removeHelper(head.next);
        if (head.next != null && head.next.val > head.val){
            head = head.next;
        }
        return head;
    }
}
