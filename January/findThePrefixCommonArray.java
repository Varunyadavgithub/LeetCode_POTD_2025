package January;

import java.util.Arrays;

// Data: 14/01/2025
//Leetcode 2657. Find the Prefix Common Array of Two Arrays.

public class findThePrefixCommonArray {
    public static int[] findPrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        boolean[] isPresentA = new boolean[n + 1];
        boolean[] isPresentB = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            isPresentA[A[i]] = true;
            isPresentB[B[i]] = true;
            int count = 0;
            for (int j = 0; j <= n; j++) {
                if (isPresentA[j] == true && isPresentB[j] == true) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A1 = { 1, 3, 2, 4 };
        int[] B1 = { 3, 1, 2, 4 };
        System.out.println("Input: A = " + Arrays.toString(A1) + ", B = " + Arrays.toString(B1));
        System.out.println("Output: " + Arrays.toString(findPrefixCommonArray(A1, B1)));

        int[] A2 = { 2, 3, 1 };
        int[] B2 = { 3, 1, 2 };
        System.out.println("Input: A = " + Arrays.toString(A2) + ", B = " + Arrays.toString(B2));
        System.out.println("Output: " + Arrays.toString(findPrefixCommonArray(A2, B2)));
    }
}
