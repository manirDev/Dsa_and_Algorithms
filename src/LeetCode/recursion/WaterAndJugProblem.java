package LeetCode.recursion;

import java.util.HashSet;
import java.util.Set;

public class WaterAndJugProblem {
    public static void main(String[] args) {
        int jug1Capacity = 1;
        int jug2Capacity = 2;
        int targetCapacity = 3;
        Set<Integer> visited = new HashSet<>();
        boolean res = canMeasureWaterHelper(jug1Capacity, jug2Capacity, targetCapacity, visited);
        System.out.println(res);
    }

    private static boolean canMeasureWaterHelper(int jug1Capacity, int jug2Capacity, int targetCapacity, Set<Integer> visited) {
        if(targetCapacity == 0){
            return true;
        }
        if (visited.contains(targetCapacity) || targetCapacity < 0 || (jug1Capacity + jug2Capacity) < targetCapacity){
            return false;
        }
        visited.add(targetCapacity);
        boolean res = canMeasureWaterHelper(jug1Capacity, jug2Capacity, targetCapacity - jug1Capacity, visited);
        res |= canMeasureWaterHelper(jug1Capacity, jug2Capacity, targetCapacity + jug1Capacity, visited);
        res |= canMeasureWaterHelper(jug1Capacity, jug2Capacity, targetCapacity - jug2Capacity, visited);
        res |= canMeasureWaterHelper(jug1Capacity, jug2Capacity, targetCapacity + jug2Capacity, visited);
        return res;
    }
}
