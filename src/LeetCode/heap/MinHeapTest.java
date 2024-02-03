package LeetCode.heap;

import LeetCode.tree.MinimumDepthOfBinaryTree;

public class MinHeapTest {
    int[] minHeap;
    int heapSize;
    int realSize = 0;
    public MinHeapTest(int heapSize){
        this.heapSize = heapSize;
        minHeap = new int[heapSize + 1];
        minHeap[0] = Integer.MAX_VALUE;
    }

    public void add(int element){
        realSize++;
        if (realSize > heapSize){
            System.out.println("Heap is overFlowed !!!");
            realSize--;
            return;
        }
        minHeap[realSize] = element;
        int idx = realSize;
        int parent = idx / 2;
        while (minHeap[idx] < minHeap[parent] && idx > 1){
            int temp = minHeap[idx];
            minHeap[idx] = minHeap[parent];
            minHeap[parent] = temp;
            idx = parent;
            parent = idx / 2;
        }
    }

    public int pop(){
        if (realSize < 1){
            System.out.println("Heap is empty");
            return minHeap[0];
        }
        int tobeRemoved = minHeap[1];
        minHeap[1] = minHeap[realSize];
        realSize--;
        int idx = 1;
        while (idx <= realSize / 2){
            int left = idx * 2;
            int right = (idx * 2) + 1;
            if (minHeap[idx] > minHeap[left] || minHeap[idx] > minHeap[right]){
                if (minHeap[idx] > minHeap[left]){
                    int temp = minHeap[idx];
                    minHeap[idx] = minHeap[left];
                    minHeap[left] = temp;
                    idx = left;
                }
                else{
                    int temp = minHeap[idx];
                    minHeap[idx] = minHeap[right];
                    minHeap[right] = temp;
                    idx = right;
                }
            }
            else{
                break;
            }
        }
        return tobeRemoved;
    }
    public String toString(){
        if (realSize < 1){
            return "No Element";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i=1; i<=realSize; i++){
            sb.append(minHeap[i]);
            sb.append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MinHeapTest minheap = new MinHeapTest(5);
        minheap.add(1);
        minheap.add(2);
        minheap.add(3);
        minheap.add(4);
        minheap.add(5);
        System.out.println(minheap.toString());
        System.out.println(minheap.pop());
        System.out.println(minheap.toString());
    }
}
