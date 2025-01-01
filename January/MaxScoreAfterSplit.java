package January;

// Data: 01/01/2025
// Leetcode 1422: Maximum Score After Splitting a String (Easy)

/**
 * Solution class for calculating the maximum score after splitting a binary
 * string.
 */
public class MaxScoreAfterSplit {

    /**
     * Approach 1: Brute Force (O(n^2) Time Complexity)
     *
     * @param s The input binary string.
     * @return The maximum score.
     */
    public static int calculateMaxScoreBruteForce(String s) {
        int n = s.length();
        int maxScore = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            // Count zeros in the left substring (0 to i)
            int zeroCount = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') {
                    zeroCount++;
                }
            }

            // Count ones in the right substring (i+1 to n-1)
            int oneCount = 0;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == '1') {
                    oneCount++;
                }
            }

            maxScore = Math.max(maxScore, zeroCount + oneCount);
        }

        return maxScore;
    }

    /**
     * Approach 2: Optimized (O(n) Time Complexity)
     *
     * @param s The input binary string.
     * @return The maximum score.
     */
    public static int calculateMaxScoreOptimized(String s) {
        int n = s.length();
        int maxScore = Integer.MIN_VALUE;

        // Precompute the total count of ones
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }

        int leftZeros = 0;
        int rightOnes = totalOnes;

        // Iterate to find the maximum score
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }

            maxScore = Math.max(maxScore, leftZeros + rightOnes);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "011101";
        String s2 = "00111";
        String s3 = "1111";
        String s4 = "00";

        // Using brute force approach
        System.out.println("Brute Force Approach:");
        System.out.println("Input: " + s1 + ", Output: " + calculateMaxScoreBruteForce(s1)); // Expected: 5
        System.out.println("Input: " + s2 + ", Output: " + calculateMaxScoreBruteForce(s2)); // Expected: 5
        System.out.println("Input: " + s3 + ", Output: " + calculateMaxScoreBruteForce(s3)); // Expected: 3
        System.out.println("Input: " + s4 + ", Output: " + calculateMaxScoreBruteForce(s4)); // Expected: 1

        // Using optimized approach
        System.out.println("\nOptimized Approach:");
        System.out.println("Input: " + s1 + ", Output: " + calculateMaxScoreOptimized(s1)); // Expected: 5
        System.out.println("Input: " + s2 + ", Output: " + calculateMaxScoreOptimized(s2)); // Expected: 5
        System.out.println("Input: " + s3 + ", Output: " + calculateMaxScoreOptimized(s3)); // Expected: 3
        System.out.println("Input: " + s4 + ", Output: " + calculateMaxScoreOptimized(s4)); // Expected: 1
    }
}
