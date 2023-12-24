package LeetCode.priorityQueue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Numerics {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(3);
        pq.add(2);
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.poll());
        PriorityQueue<String> names = new PriorityQueue<>();
        names.add("Mina");
        names.add("Mana");
        names.add("Muna");
        System.out.println(names.remove());
        System.out.println(names.remove());
        System.out.println(names.poll());
        System.out.println(names);
    }
}
