package January;

// Data: 18/01/2025
//Leetcode 1368. Minimum Cost to Make at Least One Valid Path in a Grid.

import java.util.*;

public class MinimumCostPath {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Directions for the arrows
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // right, left, down, up

        // Priority queue for Dijkstra-like approach
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // {x, y, cost}
        pq.offer(new int[] { 0, 0, 0 });

        // Visited array
        int[][] visited = new int[m][n];
        for (int[] row : visited)
            Arrays.fill(row, Integer.MAX_VALUE);
        visited[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0], y = current[1], cost = current[2];

            // If we reached the target cell, return the cost
            if (x == m - 1 && y == n - 1)
                return cost;

            // Skip if this path is not optimal
            if (cost > visited[x][y])
                continue;

            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];
                int newCost = cost + (grid[x][y] == i + 1 ? 0 : 1); // Check if direction matches

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && newCost < visited[nx][ny]) {
                    visited[nx][ny] = newCost;
                    pq.offer(new int[] { nx, ny, newCost });
                }
            }
        }

        return -1; // Should not reach here
    }

    public static void main(String[] args) {
        MinimumCostPath solver = new MinimumCostPath();

        int[][] grid1 = {
                { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 1, 1, 1, 1 },
                { 2, 2, 2, 2 }
        };
        System.out.println(solver.minCost(grid1)); // Output: 3

        int[][] grid2 = {
                { 1, 1, 3 },
                { 3, 2, 2 },
                { 1, 1, 4 }
        };
        System.out.println(solver.minCost(grid2)); // Output: 0

        int[][] grid3 = {
                { 1, 2 },
                { 4, 3 }
        };
        System.out.println(solver.minCost(grid3)); // Output: 1
    }
}
