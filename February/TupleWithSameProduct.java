package February;

import java.util.HashMap;
import java.util.Map;

// Data: 6/02/2025
//Leetcode  1726. Tuple with Same Product.

public class TupleWithSameProduct {
    public static int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCount = new HashMap<>();
        int n = nums.length;
        int count = 0;

        // Count the frequency of each product of two distinct numbers
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        // Calculate the number of valid tuples
        for (int freq : productCount.values()) {
            if (freq > 1) {
                count += (freq * (freq - 1) / 2) * 8; // Each pair can form 8 valid tuples
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 3, 4, 6 };
        int[] nums2 = { 1, 2, 4, 5, 10 };

        System.out.println("Output for nums1: " + tupleSameProduct(nums1)); // Output: 8
        System.out.println("Output for nums2: " + tupleSameProduct(nums2)); // Output: 16
    }
}
