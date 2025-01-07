package January;

// Data: 07/01/2025
//Leetcode 1408. String Matching in an Array.

import java.util.ArrayList;
import java.util.List;

public class stringMatching {
    // T.C = O(N^2) S.C = O(k)
    public static List<String> stringMatch(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Test Case 1
        String[] words1 = { "mass", "as", "hero", "superhero" };
        System.out.print("Output: " + stringMatch(words1));
        System.out.println();
        // Test Case 2
        String[] words2 = { "leetcode", "et", "code" };
        System.out.print("Output: " + stringMatch(words2));
        System.out.println();
        // Test Case 3
        String[] words3 = { "blue", "green", "bu" };
        System.out.print("Output: " + stringMatch(words3));
    }
}
