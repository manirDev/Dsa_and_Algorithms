package LeetCode.heap;

public class MaxHeap {
    int[] maxHeap;
    int heapSize;
    int realSize = 0;
    public MaxHeap(int heapSize){
        this.heapSize = heapSize;
        maxHeap = new int[heapSize  + 1];
        maxHeap[0] = Integer.MIN_VALUE;
    }

    public void add(int element){
        realSize++;
        if (realSize > heapSize){
            System.out.println("Heap overFlowed!!!");
            realSize--;
            return;
        }
        maxHeap[realSize] = element;
        int idx = realSize;
        int parent = idx / 2;
        while (maxHeap[idx] > maxHeap[parent] && idx > 1){
            int temp = maxHeap[idx];
            maxHeap[idx] = maxHeap[parent];
            maxHeap[parent] = temp;
            idx = parent;
            parent = idx / 2;
        }
    }
    public int pop(){
        if (realSize < 1){
            return maxHeap[0];
        }
        int toBeRemoved = maxHeap[1];
        maxHeap[1] = maxHeap[realSize];
        realSize--;
        int idx = 1;
        while (idx <= realSize / 2){
            int left = idx * 2;
            int right = (idx * 2) + 1;
            if (maxHeap[idx] < maxHeap[left] || maxHeap[idx] < maxHeap[right]){
                if (maxHeap[idx] < maxHeap[left]){
                    int temp = maxHeap[idx];
                    maxHeap[idx] = maxHeap[left];
                    maxHeap[left] = temp;
                    idx = left;
                }
                else{
                    int temp = maxHeap[idx];
                    maxHeap[idx] = maxHeap[right];
                    maxHeap[right] = temp;
                    idx = right;
                }
            }
            else{
                break;
            }
        }
        return toBeRemoved;
    }
    public String toString(){
        if (realSize == 0){
            return "No Element";
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i=1; i<= realSize; i++){
                sb.append(maxHeap[i]);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(4);
        maxHeap.add(2);
        maxHeap.add(3);
        maxHeap.add(1);
        maxHeap.add(4);
        System.out.println(maxHeap.toString());
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.toString());
    }
}
