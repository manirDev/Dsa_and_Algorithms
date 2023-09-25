package LeetCode.quickSort;

public class sortColors {
    public static void main(String[] args) {

    }

    private static void quickSortHelper(int[] arr, int start, int end){
        int pivotIndex = partitionHelper();
        quickSortHelper(arr, start, pivotIndex - 1);
        quickSortHelper(arr, pivotIndex + 1, end);
    }
    private static int partitionHelper(){
        return 0;
    }
}
