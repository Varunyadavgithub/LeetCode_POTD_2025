package January;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Data: 22/01/2025
//Leetcode 1765. Map of Highest Peak.

public class MapOfHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        for (int[] row : height) {
            Arrays.fill(row, -1); // Mark all cells as unvisited initially
        }

        Queue<int[]> queue = new LinkedList<>();

        // Add all water cells to the queue and set their height to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                    height[i][j] = 0;
                }
            }
        }

        // Directions for moving to adjacent cells
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check if the new cell is within bounds and unvisited
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && height[newX][newY] == -1) {
                    height[newX][newY] = height[x][y] + 1;
                    queue.offer(new int[] { newX, newY });
                }
            }
        }

        return height;
    }

    // Helper function to print the matrix
    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        MapOfHighestPeak solution = new MapOfHighestPeak();

        int[][] isWater1 = { { 0, 1 }, { 0, 0 } };
        int[][] result1 = solution.highestPeak(isWater1);
        System.out.println("Example 1:");
        solution.printMatrix(result1);

        int[][] isWater2 = { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 0, 0 } };
        int[][] result2 = solution.highestPeak(isWater2);
        System.out.println("Example 2:");
        solution.printMatrix(result2);
    }
}
