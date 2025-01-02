package January;

// Data: 02/01/2025
//Leetcode 2559. Count Vowel Strings in Ranges

public class CountVowelStringsinRanges {
    public static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] pref_sum = new int[n + 1];
        // Compute prefix sum
        for (int i = 0; i < n; i++) {
            char st = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);
            if (isVowel(st) && isVowel(end)) {
                pref_sum[i + 1] = 1 + pref_sum[i];
            } else {
                pref_sum[i + 1] = pref_sum[i];
            }
        }
        int qSize = queries.length;
        int[] ans = new int[qSize];
        for (int i = 0; i < qSize; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = pref_sum[r + 1] - pref_sum[l];
        }
        return ans;
    }

    public static void main(String[] args) {
        // Test cases
        String[] words1 = { "apple", "banana", "orange", "eat", "umbrella" };
        int[][] queries1 = { { 0, 2 }, { 1, 4 } };

        String[] words2 = { "ace", "end", "ice", "on", "up" };
        int[][] queries2 = { { 0, 4 }, { 1, 3 }, { 2, 2 } };

        // Using prefix sum approach
        System.out.println("Prefix Sum Approach:");
        int[] result1 = vowelStrings(words1, queries1);
        System.out.print("Input: [apple, banana, orange, eat, umbrella], Queries: [[0, 2], [1, 4]]\nOutput: ");
        for (int val : result1) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[] result2 = vowelStrings(words2, queries2);
        System.out.print("Input: [ace, end, ice, on, up], Queries: [[0, 4], [1, 3], [2, 2]]\nOutput: ");
        for (int val : result2) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
