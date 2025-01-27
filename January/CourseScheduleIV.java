package January;

// Data: 27/01/2025
//Leetcode 1462. Course Schedule IV.

import java.util.*;

public class CourseScheduleIV {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];

        // Build the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
            isPrerequisite[prerequisite[0]][prerequisite[1]] = true; // Direct prerequisites
        }

        // Transitive closure (Floyd-Warshall algorithm)
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    isPrerequisite[i][j] |= isPrerequisite[i][k] && isPrerequisite[k][j];
                }
            }
        }

        // Answer the queries
        for (int[] query : queries) {
            result.add(isPrerequisite[query[0]][query[1]]);
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        int[][] queries = { { 0, 1 }, { 1, 0 } };

        CourseScheduleIV solution = new CourseScheduleIV();
        List<Boolean> result = solution.checkIfPrerequisite(numCourses, prerequisites, queries);

        System.out.println(result); // Output: [false, true]
    }
}