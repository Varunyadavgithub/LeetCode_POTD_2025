package January;

// Data: 24/01/2025
//Leetcode 802. Find Eventual Safe States.

import java.util.*;

public class EventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] outDegree = new int[n];

        // Initialize the reverse graph
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        // Build the reverse graph and calculate out-degrees
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                reverseGraph.get(neighbor).add(i);
            }
            outDegree[i] = graph[i].length;
        }

        // Queue for nodes with out-degree 0 (terminal nodes)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Process nodes to find all safe nodes
        boolean[] safe = new boolean[n];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safe[node] = true;
            for (int prev : reverseGraph.get(node)) {
                outDegree[prev]--;
                if (outDegree[prev] == 0) {
                    queue.offer(prev);
                }
            }
        }

        // Collect all safe nodes
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                result.add(i);
            }
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        EventualSafeStates solution = new EventualSafeStates();

        int[][] graph1 = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        System.out.println(solution.eventualSafeNodes(graph1)); // Output: [2, 4, 5, 6]

        int[][] graph2 = { { 1, 2, 3, 4 }, { 1, 2 }, { 3, 4 }, { 0, 4 }, {} };
        System.out.println(solution.eventualSafeNodes(graph2)); // Output: [4]
    }
}
