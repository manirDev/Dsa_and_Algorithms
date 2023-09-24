package LeetCode.linkedList;

public class LinkedList {
    public Node head;
    public static class Node{
        public int data;
        public Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(list, 4);
        list.insert(list, 2);
        list.insert(list, 1);
        list.insert(list, 3);
        list.display(list);
    }

    public LinkedList insert(LinkedList list, int data){
        Node newNOde = new Node(data);
        if (list.head == null){
            list.head = newNOde;
        }
        else {
            Node last = list.head;
            while (last.next != null){
                last = last.next;
            }
            last.next = newNOde;
        }
        return list;
    }
    public void display(LinkedList list){
        Node temp = list.head;
        while (temp != null){
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }
}
