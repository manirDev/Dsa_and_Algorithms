package LeetcodeDaily.Week3_30_09_2024;

public class CustomStack {
    int[] stack;
    int idx;

    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        idx = 0;
    }

    public void push(int x) {
        if (idx < this.stack.length) {
            this.stack[idx] = x;
            idx++;
        }
    }

    public int pop() {
        if (idx > 0) {
            idx--;
            int poped = this.stack[idx];
            this.stack[idx] = 0;
            return poped;
        }
        return -1;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, idx); i++) {
            this.stack[i] += val;
        }
    }
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(5);

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Pushed 1, 2, 3 onto the stack.");

        // Pop an element
        int popped = stack.pop();
        System.out.println("Popped element: " + popped); // Should output 3

        // Push more elements
        stack.push(4);
        stack.push(5);
        System.out.println("Pushed 4, 5 onto the stack.");

        // Increment the first 2 elements by 10
        stack.increment(2, 10);
        System.out.println("Incremented the first 2 elements by 10.");

        // Pop the rest of the elements
        while (true) {
            int result = stack.pop();
            if (result == -1) {
                System.out.println("Stack is empty.");
                break;
            } else {
                System.out.println("Popped element: " + result);
            }
        }
    }
}
