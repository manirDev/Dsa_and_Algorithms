package LeetCode.priorityQueue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueClass {
    public static void main(String[] args) {
        PriorityQueue<String> queue  =new PriorityQueue<>();
        queue.add("Amit");
        queue.add("Vidal");
        queue.add("Karan");
        queue.add("Jai");
        queue.add("Rahul");
        System.out.println("Head: " + queue.element());
        System.out.println("Head: " + queue.peek());
        System.out.println("Iterating the queue elements: ");
        Iterator itr = queue.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        queue.remove();
        queue.poll();
        System.out.println("*******************");
        Iterator itr2 = queue.iterator();
        while (itr2.hasNext()){
            System.out.println(itr2.next());
        }
    }
}
