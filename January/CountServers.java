package January;

// Data: 23/01/2025
//Leetcode 1267. Count Servers that Communicate.

public class CountServers {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1))
                    res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountServers cs = new CountServers();

        // Example 1
        int[][] grid1 = { { 1, 0 }, { 0, 1 } };
        System.out.println(cs.countServers(grid1)); // Output: 0

        // Example 2
        int[][] grid2 = { { 1, 0 }, { 1, 1 } };
        System.out.println(cs.countServers(grid2)); // Output: 3

        // Example 3
        int[][] grid3 = { { 1, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
        System.out.println(cs.countServers(grid3)); // Output: 4
    }
}
