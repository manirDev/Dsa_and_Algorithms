package LeetCode.heap;

import java.util.Arrays;

public class HeapSort {
    public void heapSort(int[] arr){
        for (int i=arr.length / 2 - 1; i>=0; i--){
            maxHeapify(arr, arr.length, i);
        }
        for (int i=arr.length - 1; i>0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            maxHeapify(arr, i, 0);
        }
    }

    private void maxHeapify(int[] arr, int heapSize, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < heapSize && arr[left] > arr[largest]){
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]){
            largest = right;
        }
        if (largest != index){
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, heapSize, largest);
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {2, 6, 9, 1, 0, 3, 4, 7, 5, 8};
        heapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
