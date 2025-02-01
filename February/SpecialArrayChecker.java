package February;

// Data: 1/02/2025
//Leetcode 3151. Special Array I.

public class SpecialArrayChecker {
    public static boolean isSpecialArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                return false; // Found a pair with the same parity
            }
        }
        return true; // All pairs have different parity
    }

    public static void main(String[] args) {
        int[] nums1 = { 1 };
        int[] nums2 = { 2, 1, 4 };
        int[] nums3 = { 4, 3, 1, 6 };

        System.out.println("Test Case 1: " + isSpecialArray(nums1)); // true
        System.out.println("Test Case 2: " + isSpecialArray(nums2)); // true
        System.out.println("Test Case 3: " + isSpecialArray(nums3)); // false
    }
}
