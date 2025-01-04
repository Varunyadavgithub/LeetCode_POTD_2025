package January;

import java.util.HashSet;

// Data: 04/01/2025
//Leetcode 1930. Unique Length-3 Palindromic Subsequences.

public class countPalindromicSubsequence {
    public static int countUniqueLengthThreePalindromes(String s) {
        int n = s.length();

        // Step 1: Find all unique characters in the string
        HashSet<Character> letters = new HashSet<>();
        for (int i = 0; i < n; i++) {
            letters.add(s.charAt(i));
        }

        int res = 0; // Result variable to store the count of unique palindromes

        // Step 2: Iterate over each unique character
        for (char letter : letters) {
            int left_idx = -1;
            int right_idx = -1;
            // Step 3: Find the leftmost and rightmost occurrences of the character
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == letter) {
                    if (left_idx == -1) {
                        left_idx = i; // Set leftmost index
                    }
                    right_idx = i; // Set rightmost index
                }
            }

            // Step 4: Collect all unique characters between leftIdx and rightIdx
            HashSet<Character> set = new HashSet<>();
            for (int mid = left_idx + 1; mid <= right_idx - 1; mid++) {
                set.add(s.charAt(mid));
            }

            // Step 5: Add the size of the unique middle characters to the result
            res += set.size();
        }
        return res; // Return the total count of unique palindromic subsequences
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "aabca";
        String s2 = "adc";
        String s3 = "bbcbaba";

        System.out.println("Test case 1: " + countUniqueLengthThreePalindromes(s1)); // Output: 3
        System.out.println("Test case 2: " + countUniqueLengthThreePalindromes(s2)); // Output: 0
        System.out.println("Test case 3: " + countUniqueLengthThreePalindromes(s3)); // Output: 4
    }
}
