package LeetCode.recursion;

public class KthSymbolInGrammar {
    public static void main(String[] args) {
        int n = 3, k = 2;
        int res = helper(n, k);
        System.out.println(res);
    }
    private static int helper(int n, int k){
        if (n == 0){
            return 0;
        }
        // ceiling ==> k/2 + k%2
        int parent = helper(n - 1, k/2 + k%2);
        boolean isKOdd = k % 2 == 1;
        if (parent == 1){
            if (isKOdd){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            if (isKOdd){
                return 0;
            }
            else{
                return 1;
            }
        }
    }
}
