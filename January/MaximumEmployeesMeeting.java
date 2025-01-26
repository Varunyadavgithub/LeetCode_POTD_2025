package January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Data: 26/01/2025
//Leetcode 2127. Maximum Employees to Be Invited to a Meeting.

public class MaximumEmployeesMeeting {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;

        // Step 1: Identify the in-degrees of each node
        int[] inDegree = new int[n];
        for (int fav : favorite) {
            inDegree[fav]++;
        }

        // Step 2: Process the chains
        Queue<Integer> queue = new LinkedList<>();
        int[] chainLength = new int[n]; // chainLength[i] stores the length of the chain ending at node i
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            int fav = favorite[node];
            chainLength[fav] = Math.max(chainLength[fav], chainLength[node] + 1);
            if (--inDegree[fav] == 0) {
                queue.add(fav);
            }
        }

        // Step 3: Process the cycles
        int maxCycleSize = 0;
        int chainPairSum = 0;
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int cycleSize = 0;
                List<Integer> cycle = new ArrayList<>();

                // Detect the cycle
                int current = i;
                while (!visited[current]) {
                    visited[current] = true;
                    cycle.add(current);
                    current = favorite[current];
                }

                // Check if we are in a cycle
                if (cycle.contains(current)) {
                    int start = cycle.indexOf(current);
                    cycleSize = cycle.size() - start;
                    maxCycleSize = Math.max(maxCycleSize, cycleSize);

                    // If it's a cycle of size 2, we can pair chains from both sides
                    if (cycleSize == 2) {
                        int a = cycle.get(start);
                        int b = cycle.get(start + 1);
                        chainPairSum += 2 + chainLength[a] + chainLength[b];
                    }
                }
            }
        }

        return Math.max(maxCycleSize, chainPairSum);
    }

    public static void main(String[] args) {
        MaximumEmployeesMeeting solution = new MaximumEmployeesMeeting();

        int[] favorite1 = { 2, 2, 1, 2 };
        System.out.println(solution.maximumInvitations(favorite1)); // Output: 3

        int[] favorite2 = { 1, 2, 0 };
        System.out.println(solution.maximumInvitations(favorite2)); // Output: 3

        int[] favorite3 = { 3, 0, 1, 4, 1 };
        System.out.println(solution.maximumInvitations(favorite3)); // Output: 4
    }
}
