package LeetCode.mergeSort;


import DSA_LearningProcess.LinkedList.ListNode;
import LeetCode.linkedList.LinkedList;

public class sortList {
    public static void main(String[] args) {
        System.out.println("-------Before----------");
        LinkedList list = new LinkedList();
        list.insert(list, 4);
        list.insert(list, 2);
        list.insert(list, 1);
        list.insert(list, 3);
        list.display(list);
        System.out.println();
        System.out.println("-------After----------");
        LinkedList res = splitHelper(list);
        res.display(res);
    }
    private static LinkedList splitHelper(LinkedList list){
        if (list.head == null || list.head.next == null){
            return list;
        }
        LinkedList.Node slow = list.head;
        LinkedList.Node fast = list.head;
        LinkedList.Node temp = list.head;
        while (fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        LinkedList leftPart = new LinkedList();
        leftPart.head = list.head;
        LinkedList rightPart = new LinkedList();
        rightPart.head = slow;
        LinkedList left = splitHelper(leftPart);
        LinkedList right = splitHelper(rightPart);
        return mergerHelper(left, right);
    }
    private static LinkedList mergerHelper(LinkedList left, LinkedList right){
        LinkedList.Node temp = new LinkedList.Node(0);
        LinkedList.Node res = temp;
        LinkedList.Node leftPart = left.head;
        LinkedList.Node rightPart = right.head;
        while (leftPart != null && rightPart != null){
            if (leftPart.data < rightPart.data){
                res.next = leftPart;
                leftPart = leftPart.next;
                res = res.next;
            }
            else{
                res.next = rightPart;
                rightPart = rightPart.next;
                res = res.next;
            }
        }
        if (leftPart != null){
            res.next = leftPart;
            leftPart = leftPart.next;
        }
        if (rightPart != null){
            res.next = rightPart;
            rightPart = rightPart.next;
        }
        LinkedList result = new LinkedList();
        result.head = temp.next;
        return result;
    }
}
