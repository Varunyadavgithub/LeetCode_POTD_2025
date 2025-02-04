package February;

// Data: 4/02/2025
//Leetcode 1800. Maximum Ascending Subarray Sum.

public class MaximumAscendingSubarraySum {
    public static int maxAscendingSum(int[] nums) {
        int maxSum = nums[0]; // Initialize maxSum with the first element
        int currentSum = nums[0]; // Initialize currentSum with the first element

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // If the current number is greater than the previous, add it to currentSum
                currentSum += nums[i];
            } else {
                // If ascending order breaks, update maxSum and reset currentSum
                maxSum = Math.max(maxSum, currentSum);
                currentSum = nums[i]; // Start new subarray
            }
        }

        // Final check for the last subarray
        maxSum = Math.max(maxSum, currentSum);

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums1 = { 10, 20, 30, 5, 10, 50 };
        int[] nums2 = { 10, 20, 30, 40, 50 };
        int[] nums3 = { 12, 17, 15, 13, 10, 11, 12 };
        int[] nums4 = { 100 };

        System.out.println("Output for nums1: " + maxAscendingSum(nums1)); // Expected: 65
        System.out.println("Output for nums2: " + maxAscendingSum(nums2)); // Expected: 150
        System.out.println("Output for nums3: " + maxAscendingSum(nums3)); // Expected: 33
        System.out.println("Output for nums4: " + maxAscendingSum(nums4)); // Expected: 100
    }
}
