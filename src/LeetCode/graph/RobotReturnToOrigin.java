package LeetCode.graph;

public class RobotReturnToOrigin {
    public static void main(String[] args) {
        String moves = "ULLDRR";
        boolean res = judgeHelper(moves);
        System.out.println(res);
    }

    private static boolean judgeHelper(String moves) {
        int l=0, r=0, u=0, d=0;
        for (char move : moves.toCharArray()){
            if (move == 'L') l++;
            else if (move == 'R') r++;
            else if (move == 'D') d++;
            else if (move == 'U') u++;
        }
        boolean res = (l == r) && (u == d) ? true : false;
        return res;
    }
}
