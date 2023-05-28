package Leetcodes.String;

public class SwapAdjacentInLRStringV2 {
    public static void main(String[] args) {
        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";
        boolean flag = helper(start, end);
        if (flag){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }

    private static boolean helper(String start, String end){
        if (start.length() != end.length()){
            return false;
        }
        int i = 0;
        int j = 0;
        int[] sFreq = new int[101];
        int[] eFreq = new int[101];
        while (i<start.length()){
            sFreq[start.charAt(i) - 'A']++;
            i++;
        }
        while (j<end.length()){
            eFreq[end.charAt(j) - 'A']++;
            j++;
        }
        int k =0;
        while (k<sFreq.length && k<eFreq.length){
            if (sFreq[k] != eFreq[k]){
                return false;
            }
            k++;
        }
        return true;
    }
}
