package January;

// Data: 08/01/2025
//Leetcode 3042. Count Prefix and Suffix Pairs I.

public class PrefixSuffixPairs {
    public static int countPrefixAndSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPrefixAndSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }

    public static void main(String[] args) {
        String[] words1 = { "a", "aba", "ababa", "aa" };
        System.out.println(countPrefixAndSuffixPairs(words1)); // Output: 4

        String[] words2 = { "pa", "papa", "ma", "mama" };
        System.out.println(countPrefixAndSuffixPairs(words2)); // Output: 2

        String[] words3 = { "abab", "ab" };
        System.out.println(countPrefixAndSuffixPairs(words3)); // Output: 0
    }
}
