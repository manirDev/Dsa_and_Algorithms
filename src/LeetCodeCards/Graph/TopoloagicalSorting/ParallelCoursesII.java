package LeetCodeCards.Graph.TopoloagicalSorting;

import java.util.*;

public class ParallelCoursesII {
    static class TopoNode{
        int inDegrees;
        List<Integer> outDegrees;
        public TopoNode(){
            inDegrees = 0;
            outDegrees = new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        int n = 5, k = 2;
        int[][] relations = {{2, 1}, {3, 1}, {4, 1}, {1, 5}};
        int result = topoHelper(relations, n, k);
        System.out.println(result);
    }

    private static int topoHelper(int[][] relations, int n, int k){
        Map<Integer, TopoNode> graph = new HashMap<>();

        for (int i=1; i<=n; i++){
            graph.put(i, new TopoNode());
        }
        for (int i=0; i<relations.length; i++){
            int course = relations[i][1];
            graph.get(course).inDegrees += 1;
            graph.get(relations[i][0]).outDegrees.add(course);
        }

        PriorityQueue<Integer> topoQueue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer c1, Integer c2){
                return graph.get(c2).outDegrees.size() - graph.get(c1).outDegrees.size();
            }
        });

        for (int course=1; course<=n; course++){
            if (graph.get(course).inDegrees == 0){
                topoQueue.add(course);
            }
        }

        int minSemester = 0;
        while(!topoQueue.isEmpty()){
            Queue<Integer> nextSemester = new LinkedList<>();
            // Start taking courses for a semester
            int maxCourses = Math.min(k, topoQueue.size());
            for (int i=0; i<maxCourses; i++){
                int course = topoQueue.poll();
                for(int nextCourse : graph.get(course).outDegrees){
                    TopoNode node = graph.get(nextCourse);
                    node.inDegrees--;
                    if (node.inDegrees == 0){
                        nextSemester.add(nextCourse);
                    }
                }
            }

            minSemester++;
            for(int course : nextSemester){
                topoQueue.add(course);
            }
        }
        return minSemester;
    }
}
