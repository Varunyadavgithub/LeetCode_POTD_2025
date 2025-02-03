package February;

import java.util.Scanner;

// Data: 3/02/2025
//Leetcode 3105. Longest Strictly Increasing or Strictly Decreasing Subarray.

public class LongestMonotonicSubarray {
    public static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;

        int maxLen = 1;
        int incLen = 1, decLen = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                incLen++;
                decLen = 1; // Reset decreasing length
            } else if (nums[i] < nums[i - 1]) {
                decLen++;
                incLen = 1; // Reset increasing length
            } else {
                incLen = 1;
                decLen = 1;
            }
            maxLen = Math.max(maxLen, Math.max(incLen, decLen));
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = longestMonotonicSubarray(nums);
        System.out.println("Longest strictly increasing or decreasing subarray length: " + result);

        sc.close();
    }
}
