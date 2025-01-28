package January;

// Data: 28/01/2025
//Leetcode 2658. Maximum Number of Fish in a Grid.

public class MaximumFishInGrid {
    // Method to find the maximum number of fish
    public int maximumFishInGrid(int[][] grid) {
        int maxFish = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Visited array to track visited cells
        boolean[][] visited = new boolean[rows][cols];

        // Iterate over each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start DFS only from water cells
                if (grid[i][j] > 0 && !visited[i][j]) {
                    maxFish = Math.max(maxFish, dfs(grid, visited, i, j));
                }
            }
        }
        return maxFish;
    }

    // Helper method for DFS traversal
    private int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        // Check bounds and if the cell is already visited or is a land cell
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }

        // Mark the current cell as visited
        visited[r][c] = true;

        // Start with the fish count in the current cell
        int fishCount = grid[r][c];

        // Explore all 4 possible directions
        fishCount += dfs(grid, visited, r + 1, c); // Down
        fishCount += dfs(grid, visited, r - 1, c); // Up
        fishCount += dfs(grid, visited, r, c + 1); // Right
        fishCount += dfs(grid, visited, r, c - 1); // Left

        return fishCount;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        MaximumFishInGrid solution = new MaximumFishInGrid();

        // Test Case 1
        int[][] grid1 = {
                { 0, 2, 1, 0 },
                { 4, 0, 0, 3 },
                { 1, 0, 0, 4 },
                { 0, 3, 2, 0 }
        };
        System.out.println("Maximum Fish (Test Case 1): " + solution.maximumFishInGrid(grid1)); // Output: 7

        // Test Case 2
        int[][] grid2 = {
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 1 }
        };
        System.out.println("Maximum Fish (Test Case 2): " + solution.maximumFishInGrid(grid2)); // Output: 1

        // Test Case 3
        int[][] grid3 = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };
        System.out.println("Maximum Fish (Test Case 3): " + solution.maximumFishInGrid(grid3)); // Output: 0

        // Test Case 4
        int[][] grid4 = {
                { 5, 8, 0 },
                { 0, 10, 15 },
                { 0, 0, 20 }
        };
        System.out.println("Maximum Fish (Test Case 4): " + solution.maximumFishInGrid(grid4)); // Output: 20
    }
}
