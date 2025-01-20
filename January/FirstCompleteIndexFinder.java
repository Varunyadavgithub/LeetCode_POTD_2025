package January;

// Data: 20/01/2025
//Leetcode 2661. First Completely Painted Row or Column.

import java.util.HashMap;
import java.util.Map;

public class FirstCompleteIndexFinder {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Step 1: Create a lookup for each value in the matrix
        Map<Integer, int[]> lookup = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lookup.put(mat[i][j], new int[] { i, j });
            }
        }

        // Step 2: Find the earliest row or column painted
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int[] coordinate = lookup.get(arr[i]);
            int x = coordinate[0];
            int y = coordinate[1];
            rowCount[x]++;
            colCount[y]++;
            if (rowCount[x] == n || colCount[y] == m) {
                return i;
            }
        }

        // If no row or column is completely painted, return 0 (this case won't occur as
        // per constraints)
        return 0;
    }

    public static void main(String[] args) {
        FirstCompleteIndexFinder finder = new FirstCompleteIndexFinder();

        // Example 1
        int[] arr1 = { 1, 3, 4, 2 };
        int[][] mat1 = { { 1, 4 }, { 2, 3 } };
        System.out.println("Example 1 Output: " + finder.firstCompleteIndex(arr1, mat1)); // Output: 2

        // Example 2
        int[] arr2 = { 2, 8, 7, 4, 1, 3, 5, 6, 9 };
        int[][] mat2 = { { 3, 2, 5 }, { 1, 4, 6 }, { 8, 7, 9 } };
        System.out.println("Example 2 Output: " + finder.firstCompleteIndex(arr2, mat2)); // Output: 3
    }
}
