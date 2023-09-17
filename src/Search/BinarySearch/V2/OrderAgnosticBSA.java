package Search.BinarySearch.V2;

public class OrderAgnosticBSA {
    public static void main(String[] args) {
        int[] asc = {1, 2, 4, 6, 7, 8, 9, 11};
        int[] desc = {11, 9, 8, 7, 6, 4, 2, 1};
        int target = 11;
        System.out.println("Iterative Function:");
        long time = System.currentTimeMillis();
        System.out.println("ASC : " + helper(asc, target));
        System.out.printf("Time using Iteration: %d ms\n", System.currentTimeMillis() - time);
        System.out.println("DESC: " + helper(desc, target));
    }
    private static int helper(int[] a, int t){
        int s = 0;
        int e = a.length - 1;
        boolean isAsc = a[s] < a[e];
        while(s <= e){
            int mid = s  + (e - s)/2;
            if (a[mid] == t){
                return mid;
            }
            if (isAsc){
                if(a[mid] < t){
                    s = mid + 1;
                }
                else {
                    e = mid - 1;
                }
            }
            if (!isAsc){
                if(a[mid] < t){
                    e = mid - 1;
                }
                else {
                    e = mid + 1;
                }
            }
        }
        return -1;
    }
}
