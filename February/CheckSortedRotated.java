package February;

// Data: 2/02/2025
//Leetcode 1752. Check if Array Is Sorted and Rotated.

public class CheckSortedRotated {
    // public static boolean check(int[] nums) { // T.C=O(n^2) and S.C=O(n)
    //     int n = nums.length;

    //     for (int r = 0; r < n; r++) { // Rotate from 0 to n-1
    //         int[] rotatedArr = new int[n];
    //         int idx = 0;

    //         // Create the rotated array
    //         for (int i = r; i < n; i++) {
    //             rotatedArr[idx++] = nums[i];
    //         }
    //         for (int i = 0; i < r; i++) {
    //             rotatedArr[idx++] = nums[i];
    //         }

    //         // Check if rotatedArr is sorted in non-decreasing order
    //         boolean isSorted = true;
    //         for (int i = 0; i < n - 1; i++) {
    //             if (rotatedArr[i] > rotatedArr[i + 1]) { // If not sorted
    //                 isSorted = false;
    //                 break;
    //             }
    //         }

    //         if (isSorted)
    //             return true; // If sorted in any rotation, return true
    //     }

    //     return false; // If no sorted rotation found
    // }

    public static boolean check(int[] nums){ // T.C=O(n) and S.C=(1)
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n]) count++; // Use (i + 1) % n to handle the circular rotation check (comparing the last element with the first).
            if(count>1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                { 3, 4, 5, 1, 2 }, // true
                { 2, 1, 3, 4 }, // false
                { 1, 2, 3 }, // true
                { 1, 1, 1 }, // true
                { 4, 5, 6, 7, 1, 2, 3 } // true
        };

        for (int[] testCase : testCases) {
            System.out.println(check(testCase));
        }
    }
}
