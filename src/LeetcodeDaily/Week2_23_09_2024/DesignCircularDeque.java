package LeetcodeDaily.Week2_23_09_2024;

import Libraries.Node;

class MyCircularDeque {
    Node front;
    Node rear;
    int size;
    int capacity;

    public MyCircularDeque(int k) {
        this.size = 0;
        this.front = null;
        this.rear = null;
        this.capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;
        Node newNode = new Node(value);
        if (front == null) {
            front = newNode;
            rear = front;
            size++;
            return true;
        }
        newNode.next = front;
        front.prev = newNode;
        front = newNode;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;
        Node newNode = new Node(value);
        if (rear == null) {
            rear = newNode;
            front = rear;
            size++;
            return true;
        }
        rear.next = newNode;
        newNode.prev = rear;
        rear = newNode;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        if (size == 1) {
            front = null;
            rear = null;
            size = 0;
            return true;
        }
        Node next = front.next;
        next.prev = null;
        front.next = null;
        front = next;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        if (size == 1) {
            front = null;
            rear = null;
            size = 0;
            return true;
        }
        Node prev = rear.prev;
        rear.prev = null;
        prev.next = null;
        rear = prev;
        size--;
        return true;

    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return front.val;
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return rear.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= capacity;
    }

    public static void main(String[] args) {

    }
}

