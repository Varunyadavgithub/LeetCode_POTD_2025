package January;

import java.util.Scanner;

// Data: 06/01/2025
//Leetcode 1769. Minimum Number of Operations to Move All Balls to Each Box.

public class minOperations {
    // Brute Force Solution T.C = O(N^2)
    public static int[] bruteForceMinOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int operation = 0;
            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) == '1') {
                    operation += Math.abs(i - j);
                }
            }
            res[i] = operation;
        }
        return res;
    }

    // Optimized Solution T.C = O(N)
    public static int[] optimizedMinOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        int travel = 0; // Tracks cumulative operations
        int ones = 0; // Tracks the number of '1's encountered
        // left to right pass
        for (int i = 0; i < n; i++) {
            travel += ones;
            res[i] += travel;
            if (boxes.charAt(i) == '1') {
                ones++;
            }
        }
        travel = 0; // Reset travel for the second pass
        ones = 0; // Reset ones for the second pass

        // Right-to-left pass
        for (int i = n - 1; i >= 0; i--) {
            travel += ones;
            res[i] += travel;
            if (boxes.charAt(i) == '1') {
                ones++;
            }
        }
        return res;
    }

    public static void printResult(int[] result) {
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the binary string
        System.out.print("Enter the binary string representing boxes:");
        String boxes = sc.nextLine();

        // Call the brute force solution
        // int[] result = bruteForceMinOperations(boxes);
        // Call the Optimized Solution
        int[] result = optimizedMinOperations(boxes);

        // Output the result
        System.out.println("Minimum number of operations to move all balls to each box:");
        printResult(result);

        sc.close();
    }
}
