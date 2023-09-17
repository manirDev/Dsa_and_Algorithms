package Search.BinarySearch.V2;
public class LinkedList {
    Node head;
    static class  Node{
        public int data;
        public Node next;
        public Node(int val){
            this.data = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(list, 1);
        list.insert(list, 2);
        list.insert(list, 3);
        list.insert(list, 4);
        list.insert(list, 5);
        list.insert(list, 6);
        list.insert(list, 7);
        list.insert(list, 8);

        printList(list);
        System.out.println();
        System.out.println("BSA: " + helper(list, 8));
    }
    private static LinkedList insert(LinkedList list, int data){
        Node node = new Node(data);
        if (list.head == null){
            list.head = node;
        }
        else{
            Node last = list.head;
            while (last.next != null){
                last = last.next;
            }
            //insert at the end;
            last.next = node;
        }
        return list;
    }
    private  static void printList(LinkedList list){
        Node curr = list.head;
        while (curr != null){
            System.out.printf(curr.data + " ");
            curr = curr.next;
        }
    }

    private static int helper(LinkedList list, int target){
        Node start = list.head;
        Node end = null;
        while (start != end){
            Node mid = middle(start, end);
            if (mid.data == target){
                return mid.data;
            }
            if (mid.data < target){
                start = mid.next;
            }else {
                end = mid;
            }
        }
        return -1;
    }

    private static Node middle(Node start, Node end){
        if (start == null){
            return null;
        }
        Node slow = start;
        Node fast = start;
        while (fast != end){
            fast = fast.next;
            if (fast != end){
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

}
