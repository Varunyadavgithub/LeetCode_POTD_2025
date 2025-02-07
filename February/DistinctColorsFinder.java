package February;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Data: 7/02/2025
//Leetcode  3160. Find the Number of Distinct Colors Among the Balls.

public class DistinctColorsFinder {
    public static int[] findDistinctColors(int limit, int[][] queries) {
        Map<Integer, Integer> ballToColor = new HashMap<>(); // Maps each ball to its color
        Map<Integer, Integer> colorToBalls = new HashMap<>(); // Maps each color to the count of balls having that color
        int[] result = new int[queries.length];
        int distinctColorCount = 0;

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballToColor.containsKey(ball)) {
                int prevColor = ballToColor.get(ball);
                // Reduce the count of the previous color
                colorToBalls.put(prevColor, colorToBalls.get(prevColor) - 1);
                if (colorToBalls.get(prevColor) == 0) {
                    colorToBalls.remove(prevColor);
                    distinctColorCount--; // A color is completely removed
                }
            }

            // Assign new color
            ballToColor.put(ball, color);
            // Increase count of the new color
            colorToBalls.put(color, colorToBalls.getOrDefault(color, 0) + 1);
            if (colorToBalls.get(color) == 1) {
                distinctColorCount++; // A new distinct color is added
            }

            result[i] = distinctColorCount;
        }
        return result;
    }

    public static void main(String[] args) {
        int limit1 = 4;
        int[][] queries1 = { { 1, 4 }, { 2, 5 }, { 1, 3 }, { 3, 4 } };
        System.out.println(Arrays.toString(findDistinctColors(limit1, queries1))); // Output: [1, 2, 2, 3]

        int limit2 = 4;
        int[][] queries2 = { { 0, 1 }, { 1, 2 }, { 2, 2 }, { 3, 4 }, { 4, 5 } };
        System.out.println(Arrays.toString(findDistinctColors(limit2, queries2))); // Output: [1, 2, 2, 3, 4]
    }
}
