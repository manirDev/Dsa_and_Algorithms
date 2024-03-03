package LeetCode.linkedList;

public class RemoveNthNodeFromEndOfList {
    static int i = 0;
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head = head.insertNode(head, 4);
        head = head.insertNode(head, 3);
        head = head.insertNode(head, 2);
        head = head.insertNode(head, 1);
        head.print(head);
        int n = 2;
         ListNode res = removeNthFromEndHelper(head, n);
        System.out.println();
        res.print(res);

    }

    public static ListNode removeNthFromEndHelper(ListNode head, int n) {
        if(head==null) return head;
        ListNode p = head;
        int len = findLen(p);
        if(len==n) return head.next;
        ListNode temp = head;
        ListNode prev = null;
        int i = 0;
        while(i<len-n){
            prev = temp;
            temp = temp.next;
            i++;
        }
        prev.next = temp.next;
        return head;
    }
    private static int findLen(ListNode node){
        int count = 0;
        while(node!=null){
            count++;
            node = node.next;
        }
        return count;
    }
}
