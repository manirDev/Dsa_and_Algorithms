package LeetCodeCards.Graph.TopoloagicalSorting;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{0, 1}, {1, 0}};
        int[] result = topologicalHelper(numCourses, prerequisites);
        System.out.println(Arrays.toString(result));
    }

    private static int[] topologicalHelper(int n, int[][] prerequisites){
        int[] inDegrees = new int[n];
        int[] res = new int[n];
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int course=0; course<n; course++){
            adjList.put(course, new ArrayList<>());
        }

        for (int i=0; i<prerequisites.length; i++){
            int index = prerequisites[i][0];
            inDegrees[index] += 1;
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> topoQueue = new LinkedList<>();
        for (int i=0; i<n; i++){
            if (inDegrees[i] == 0){
                topoQueue.add(i);
            }
        }
        int idx = 0;
        while(!topoQueue.isEmpty()){
            int vertex = topoQueue.poll();
            for (int adj : adjList.get(vertex)){
                if (inDegrees[adj] > 0){
                    inDegrees[adj] -= 1;
                    if (inDegrees[adj] == 0){
                        topoQueue.add(adj);
                    }
                }
            }
            res[idx] = vertex;
            idx++;
        }

        return idx == n ? res : new int[]{};
    }
}
