package LeetCode.linkedList;

public class mergeTwoLists {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insert(list1, 1);
        list1.insert(list1, 2);
        list1.insert(list1, 4);
        LinkedList list2 = new LinkedList();
        list2.insert(list2, 1);
        list2.insert(list2, 3);
        list2.insert(list2, 4);
        LinkedList res = mergeHelper(list1, list2);
        res.display(res);
    }
    private static LinkedList mergeHelper(LinkedList left, LinkedList right){
        LinkedList.Node leftPart = left.head;
        LinkedList.Node rightPart = right.head;
        LinkedList.Node temp = new LinkedList.Node(0);
        LinkedList.Node res = temp;
        while (leftPart != null && rightPart != null){
            if (leftPart.data < rightPart.data){
                res.next = leftPart;
                res = res.next;
                leftPart = leftPart.next;
            }
            else {
                res.next = rightPart;
                res = res.next;
                rightPart = rightPart.next;
            }
        }
        if (leftPart != null){
            res.next = leftPart;
        }
        if (rightPart != null){
            res.next = rightPart;
        }
        LinkedList result = new LinkedList();
        result.head = temp.next;
        return result;
    }
}
