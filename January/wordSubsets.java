package January;

import java.util.ArrayList;
import java.util.List;

// Data: 10/01/2025
//Leetcode 916. Word Subsets.

public class wordSubsets {
    public static void setMaxFreq(int[] freqWord2, int[] freq) {
        for (int i = 0; i < 26; i++) {
            freqWord2[i] = Math.max(freqWord2[i], freq[i]);
        }
    }

    public static boolean isUniversal(int[] freqWord, int[] freqWord2) {
        for (int i = 0; i < 26; i++) {
            if (freqWord[i] < freqWord2[i])
                return false;
        }
        return true;
    }

    public static List<String> wordSubset(String[] words1, String[] words2) {
        int[] freqWord2 = new int[26];
        for (String word : words2) {
            int[] freq = new int[26];
            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }
            setMaxFreq(freqWord2, freq);
        }
        // Find universal words from words1
        List<String> universalWords = new ArrayList<>();
        for (String word : words1) {
            int[] freqWord = new int[26];
            for (char c : word.toCharArray()) {
                freqWord[c - 'a']++;
            }
            if (isUniversal(freqWord, freqWord2)) {
                universalWords.add(word);
            }
        }
        return universalWords;
    }

    public static void main(String[] args) {
        String[] words1 = { "amazon", "apple", "facebook", "google", "leetcode" };
        String[] words2 = { "e", "o" };
        List<String> result1 = wordSubset(words1, words2);
        System.out.print("Test Case 1: " + result1);
        System.out.println();
        // Test case 2
        String[] words1_2 = { "amazon", "apple", "facebook", "google", "leetcode" };
        String[] words2_2 = { "l", "e" };
        List<String> result2 = wordSubset(words1_2, words2_2);
        System.out.print("Test Case 2: " + result2);
    }
}
