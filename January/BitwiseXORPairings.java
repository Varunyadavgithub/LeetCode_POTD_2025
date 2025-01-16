package January;

// Data: 16/01/2025
//Leetcode 2425. Bitwise XOR of All Pairings

public class BitwiseXORPairings {
    public static int xorAllPairings(int[] nums1, int[] nums2) {
        int xor1 = 0, xor2 = 0;

        // Compute XOR of all elements in nums1
        for (int num : nums1) {
            xor1 ^= num;
        }

        // Compute XOR of all elements in nums2
        for (int num : nums2) {
            xor2 ^= num;
        }

        // Apply observation
        int result = 0;

        // If nums1.length is odd, include xor2 in the result
        if (nums1.length % 2 != 0) {
            result ^= xor2;
        }

        // If nums2.length is odd, include xor1 in the result
        if (nums2.length % 2 != 0) {
            result ^= xor1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 1, 3 };
        int[] nums2 = { 10, 2, 5, 0 };
        System.out.println(xorAllPairings(nums1, nums2)); // Output: 13

        int[] nums1_2 = { 1, 2 };
        int[] nums2_2 = { 3, 4 };
        System.out.println(xorAllPairings(nums1_2, nums2_2)); // Output: 0
    }
}
