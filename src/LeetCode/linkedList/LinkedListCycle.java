package LeetCode.linkedList;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        boolean res = hasCycleHelper(head);
        System.out.println(res);
    }

    private static boolean hasCycleHelper(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
