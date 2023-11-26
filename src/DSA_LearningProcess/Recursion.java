package DSA_LearningProcess;

public class Recursion {
    public static void main(String[] args) {
        solve(10);
        System.out.println("----------------------------");
        System.out.println(sum(5));
    }
    public static void solve(int n){
        // Base condition
        if(n == 0) return;

        solve(n - 1); // Hypothesis
        System.out.println(n); // Induction
    }
    public static int sum(int n){
        // Base condition
        if(n == 0) return 0; //f(0) ==> 0
        //System.out.printf("%d",n ,"+", "f( %d",n-1, ")\n"); // n + f(n-1)
        System.out.println(n + " + f(%d)"+ (n-1));
        return (n + sum(n - 1)); //1 + f(0) ==> 2 + 1 => 3 + 3

    }
}
