package January;

// Data: 21/01/2025
//Leetcode 2017. Grid Game.

public class GridGame {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        // Prefix sums for row 0 and row 1
        long[] prefixRow0 = new long[n + 1];
        long[] prefixRow1 = new long[n + 1];

        // Compute prefix sums
        for (int i = 0; i < n; i++) {
            prefixRow0[i + 1] = prefixRow0[i] + grid[0][i];
            prefixRow1[i + 1] = prefixRow1[i] + grid[1][i];
        }

        // Minimize the maximum points the second robot can collect
        long minPoints = Long.MAX_VALUE;
        for (int c = 0; c < n; c++) {
            // Points left for the second robot
            long top = prefixRow0[n] - prefixRow0[c + 1]; // Top row points after column c
            long bottom = prefixRow1[c]; // Bottom row points before column c

            // Maximum points the second robot can collect
            long secondRobotPoints = Math.max(top, bottom);

            // Minimize the maximum points
            minPoints = Math.min(minPoints, secondRobotPoints);
        }

        return minPoints;
    }

    public static void main(String[] args) {
        GridGame solution = new GridGame();

        int[][] grid1 = { { 2, 5, 4 }, { 1, 5, 1 } };
        System.out.println(solution.gridGame(grid1)); // Output: 4

        int[][] grid2 = { { 3, 3, 1 }, { 8, 5, 2 } };
        System.out.println(solution.gridGame(grid2)); // Output: 4

        int[][] grid3 = { { 1, 3, 1, 15 }, { 1, 3, 3, 1 } };
        System.out.println(solution.gridGame(grid3)); // Output: 7
    }
}
