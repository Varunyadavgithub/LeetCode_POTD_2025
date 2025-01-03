package January;

// Data: 03/01/2025
//Leetcode 2270. Number of Ways to Split Array.

public class waysToSplitArray {
    public static int validSplits(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        long leftSum = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            long rightSum = totalSum - leftSum;
            if (leftSum >= rightSum)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = { 10, 4, -8, 7 };
        int[] nums2 = { 2, 3, 1, 0 };
        System.out.print("Test Case 1: " + validSplits(nums1));
        System.out.print("Test Case 2: " + validSplits(nums2));
    }
}
