package LeetCode.dp;

public class MinimumTimeToMakeRopeColorful {
    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = {1,2,3,4,5};
        int res = minCostHelper(colors, neededTime);
        System.out.println(res);
    }
    private static int minCostHelper(String colors, int[] neededTime){
        int minTime = 0;
        for(int i=0; i<colors.length()-1; i++){
            if(colors.charAt(i) == colors.charAt(i+1)){
                if(neededTime[i] < neededTime[i+1]){
                    minTime += neededTime[i];
                }else{
                    minTime += neededTime[i+1];
                    neededTime[i+1] = neededTime[i];
                }
            }
        }
        return minTime;
    }
}
