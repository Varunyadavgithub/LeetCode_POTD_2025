package January;

// Data: 09/01/2025
//Leetcode 2185. Counting Words With a Given Prefix.

public class prefixCount {
    // T.C = O(N)
    public static int countPrefix(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Example 1
        String[] words1 = { "pay", "attention", "practice", "attend" };
        String pref1 = "at";
        System.out.println(countPrefix(words1, pref1)); // Output: 2

        // Example 2
        String[] words2 = { "leetcode", "win", "loops", "success" };
        String pref2 = "code";
        System.out.println(countPrefix(words2, pref2)); // Output: 0 }
    }
}