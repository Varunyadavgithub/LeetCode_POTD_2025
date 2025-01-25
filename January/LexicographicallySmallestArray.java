package January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Data: 25/01/2025
//Leetcode 2948. Make Lexicographically Smallest Array by Swapping Elements.

public class LexicographicallySmallestArray {
    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        // Step 1: Pair each number with its index
        List<int[]> sortedValuesWithIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sortedValuesWithIndices.add(new int[] { nums[i], i });
        }

        // Step 2: Sort the array by value
        sortedValuesWithIndices.sort(Comparator.comparingInt(a -> a[0]));

        // Step 3: Identify groups and assign sorted values to original indices
        int groupStart = 0, groupEnd = 1;
        while (groupEnd < n) {
            // Find connected component based on the limit
            List<Integer> positions = new ArrayList<>();
            positions.add(sortedValuesWithIndices.get(groupStart)[1]); // Add the first element of the group
            while (groupEnd < n &&
                    Math.abs(sortedValuesWithIndices.get(groupEnd)[0]
                            - sortedValuesWithIndices.get(groupEnd - 1)[0]) <= limit) {
                positions.add(sortedValuesWithIndices.get(groupEnd)[1]);
                groupEnd++;
            }

            // Sort the positions and assign sorted values to original indices
            Collections.sort(positions);
            for (int i = 0; i < groupEnd - groupStart; i++) {
                nums[positions.get(i)] = sortedValuesWithIndices.get(groupStart + i)[0];
            }

            // Move to the next group
            groupStart = groupEnd;
            groupEnd++;
        }

        return nums;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = { 1, 5, 3, 9, 8 };
        int limit1 = 2;
        System.out.println("Input: " + Arrays.toString(nums1) + ", Limit: " + limit1);
        int[] result1 = lexicographicallySmallestArray(nums1, limit1);
        System.out.println("Output: " + Arrays.toString(result1));

        // Example 2
        int[] nums2 = { 1, 7, 6, 18, 2, 1 };
        int limit2 = 3;
        System.out.println("\nInput: " + Arrays.toString(nums2) + ", Limit: " + limit2);
        int[] result2 = lexicographicallySmallestArray(nums2, limit2);
        System.out.println("Output: " + Arrays.toString(result2));

        // Example 3
        int[] nums3 = { 1, 7, 28, 19, 10 };
        int limit3 = 3;
        System.out.println("\nInput: " + Arrays.toString(nums3) + ", Limit: " + limit3);
        int[] result3 = lexicographicallySmallestArray(nums3, limit3);
        System.out.println("Output: " + Arrays.toString(result3));
    }
}
