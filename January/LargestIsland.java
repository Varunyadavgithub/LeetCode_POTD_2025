package January;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Data: 31/01/2025
//Leetcode 827. Making A Large Island.

public class LargestIsland {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        int maxIsland = 0;
        int islandIndex = 2; // Start index from 2 to differentiate from original 1s
        Map<Integer, Integer> islandSizes = new HashMap<>();

        // Step 1: Identify all islands and store their sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandIndex);
                    islandSizes.put(islandIndex, size);
                    maxIsland = Math.max(maxIsland, size);
                    islandIndex++;
                }
            }
        }

        // Step 2: Check every 0 and calculate the maximum possible island size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> adjacentIslands = new HashSet<>();
                    int possibleSize = 1; // Convert this 0 to 1

                    for (int[] dir : DIRECTIONS) {
                        int newX = i + dir[0];
                        int newY = j + dir[1];
                        if (newX >= 0 && newY >= 0 && newX < n && newY < n && grid[newX][newY] > 1) {
                            adjacentIslands.add(grid[newX][newY]);
                        }
                    }

                    for (int index : adjacentIslands) {
                        possibleSize += islandSizes.get(index);
                    }

                    maxIsland = Math.max(maxIsland, possibleSize);
                }
            }
        }

        return maxIsland;
    }

    // DFS to find island size and mark it with an index
    private static int dfs(int[][] grid, int x, int y, int islandIndex) {
        int n = grid.length;
        if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] != 1)
            return 0;

        grid[x][y] = islandIndex;
        int size = 1;

        for (int[] dir : DIRECTIONS) {
            size += dfs(grid, x + dir[0], y + dir[1], islandIndex);
        }

        return size;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        int[][] grid1 = { { 1, 0 }, { 0, 1 } };
        int[][] grid2 = { { 1, 1 }, { 1, 0 } };
        int[][] grid3 = { { 1, 1 }, { 1, 1 } };

        System.out.println("Test Case 1: " + largestIsland(grid1)); // Output: 3
        System.out.println("Test Case 2: " + largestIsland(grid2)); // Output: 4
        System.out.println("Test Case 3: " + largestIsland(grid3)); // Output: 4
    }
}
