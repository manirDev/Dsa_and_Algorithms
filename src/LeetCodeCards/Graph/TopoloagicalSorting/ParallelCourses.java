package LeetCodeCards.Graph.TopoloagicalSorting;

import java.util.*;

public class ParallelCourses {
    public static void main(String[] args) {
        int n = 3;
        int[][] relations = {{1, 3}, {2, 3}};
        int result = topoHelper(relations, n);
        System.out.println(result);
    }

    private static int topoHelper(int[][] relations, int n){
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegrees = new int[n];

        for (int v=1; v<=n; v++){
            adjList.put(v, new ArrayList<>());
        }

        for (int i=0; i<relations.length; i++){
            int index = relations[i][1];
            inDegrees[index - 1] += 1;
            adjList.get(relations[i][0]).add(relations[i][1]);
        }

        Queue<Integer> topoQueue = new LinkedList<>();
        for (int i=0; i<n; i++){
            if (inDegrees[i] == 0){
                topoQueue.offer(i + 1);
            }
        }
        int courseToTake = 0;
        int semesters = 0;
        while (!topoQueue.isEmpty()){
            int size = topoQueue.size();
            for (int i=0; i<size; i++){
                int course = topoQueue.poll();
                for (int adj : adjList.get(course)){
                    if (inDegrees[adj - 1] > 0){
                        inDegrees[adj - 1] -= 1;
                        if (inDegrees[adj - 1] == 0){
                            topoQueue.offer(adj);
                        }
                    }
                }
                courseToTake++;
            }
            semesters++;
        }

        return courseToTake == n ? semesters : -1;
    }
}
