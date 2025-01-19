package January;

// Data: 19/01/2025
//Leetcode 407. Trapping Rain Water II.

import java.util.PriorityQueue;

public class TrappingRainWaterII {
    private static class Cell {
        int row, col, height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int rows = heightMap.length;
        int cols = heightMap[0].length;
        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Add all boundary cells to the heap
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    minHeap.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        // Directions for moving up, down, left, right
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int waterTrapped = 0;

        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();

            // Process all unvisited neighbors
            for (int[] dir : directions) {
                int newRow = cell.row + dir[0];
                int newCol = cell.col + dir[1];

                // Check boundaries and visited status
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    // Calculate trapped water
                    waterTrapped += Math.max(0, cell.height - heightMap[newRow][newCol]);
                    // Update height of the current cell
                    minHeap.offer(new Cell(newRow, newCol, Math.max(cell.height, heightMap[newRow][newCol])));
                }
            }
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        TrappingRainWaterII solver = new TrappingRainWaterII();
        int[][] heightMap1 = {
                { 1, 4, 3, 1, 3, 2 },
                { 3, 2, 1, 3, 2, 4 },
                { 2, 3, 3, 2, 3, 1 }
        };
        System.out.println("Water trapped: " + solver.trapRainWater(heightMap1)); // Output: 4

        int[][] heightMap2 = {
                { 3, 3, 3, 3, 3 },
                { 3, 2, 2, 2, 3 },
                { 3, 2, 1, 2, 3 },
                { 3, 2, 2, 2, 3 },
                { 3, 3, 3, 3, 3 }
        };
        System.out.println("Water trapped: " + solver.trapRainWater(heightMap2)); // Output: 10
    }
}
